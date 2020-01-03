package com.example.demo.entities;

import com.example.demo.enums.TransactionType;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.TransactionRepository;
import com.example.demo.serializers.AccountDeserializer;
import com.example.demo.serializers.TransactionTypeDeserializer;
import com.example.demo.serializers.TransactionTypeSerializer;
import com.example.demo.services.TransactionService;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class TransactionTest {

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    private ObjectMapper mapper;
    private TransactionTypeSerializer serializer;
    private TransactionTypeDeserializer deserializer;
    
    @Rule//(expected = ObjectNotFoundException.class)
    public ExpectedException exception = ExpectedException.none();

    @Autowired
    private MockMvc mvc;
    
    @Autowired
    private TransactionService transactionService;
    
    @MockBean
    private TransactionRepository transactionRepository;

    @MockBean
    private AccountRepository accountRepository;
    
    @Mock
    private JsonGenerator gen;

    @Before
    public void setUp() throws Exception {
        mapper = new ObjectMapper();
        serializer = new TransactionTypeSerializer();
        deserializer = new TransactionTypeDeserializer();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void serializeTransactionType() throws IOException {
        TransactionType type = TransactionType.fromName("Interest Earned");
        serializer.serialize(type, gen, null);

        String expected = "Interest Earned";
        verify(gen, times(1)).writeString(expected);
    }

    @Test
    public void serializeTransaction() throws IOException {
        TransactionType type = TransactionType.fromName("Interest Earned");
        Account account1 = new Checking(1L,450.60,LocalDate.parse("2010-08-23"),null,"MyChecking");
        Transaction transaction = new Transaction(234L, type, 123.45, account1, "testaction", null, 456.78);
        String actual = mapper.writeValueAsString(transaction);

        String expected = "{\"id\":234,\"type\":\"Interest Earned\",\"amount\":123.45,\"account\":\"1\",\"comment\":\"testaction\",\"dateCreated\":null,\"accountBalance\":456.78}";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deserializeTransaction() throws IOException {
        TransactionType type = TransactionType.fromName("Interest Earned");
        Transaction transaction = new Transaction(234L, type, 123.45, null, "testaction", null, 456.78);
        String json = "{\"id\":234,\"type\":\"Interest Earned\",\"amount\":123.45,\"account\":null,\"comment\":\"testaction\",\"dateCreated\":null,\"accountBalance\":456.78}";
        Transaction output = mapper.readValue(json, Transaction.class);

        Assert.assertEquals(transaction.getId(),output.getId());
    }

    
    private List<Transaction> stubTransactions() {
        Account account1 = new Checking(1L,450.60,LocalDate.parse("2010-08-23"),null,"MyChecking");
        Account account2 = new Checking(2L,350.60,LocalDate.parse("2010-08-25"),null,"MyChecking2");
        Transaction transaction1 = new Transaction(23L,TransactionType.fromName("Fee"),123.45, account1, "fun", LocalDate.parse("2015-02-05"), 200.00);
        Transaction transaction2 = new Transaction(24L,TransactionType.fromName("Fee"),123.45, account1, "fun", LocalDate.parse("2015-02-05"), 200.00);
        Transaction transaction3 = new Transaction(25L,TransactionType.fromName("Fee"),123.45, account2, "fun", LocalDate.parse("2015-02-05"), 200.00);
        Transaction transaction4 = new Transaction(26L,TransactionType.fromName("Fee"),123.45, account2, "fun", LocalDate.parse("2015-02-05"), 200.00);

        return Arrays.asList(transaction1,transaction2,transaction3,transaction4);
    }

    @Test
    public void getAllTransactions() throws Exception {
        when(transactionRepository.findAll()).thenReturn(stubTransactions());

        this.mvc.perform(MockMvcRequestBuilders
                .get("/transactions"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("[{\"id\":23,\"type\":\"Fee\",\"amount\":123.45,\"account\":\"1\",\"comment\":\"fun\",\"dateCreated\":[2015,2,5],\"accountBalance\":200.0},{\"id\":24,\"type\":\"Fee\",\"amount\":123.45,\"account\":\"1\",\"comment\":\"fun\",\"dateCreated\":[2015,2,5],\"accountBalance\":200.0},{\"id\":25,\"type\":\"Fee\",\"amount\":123.45,\"account\":\"2\",\"comment\":\"fun\",\"dateCreated\":[2015,2,5],\"accountBalance\":200.0},{\"id\":26,\"type\":\"Fee\",\"amount\":123.45,\"account\":\"2\",\"comment\":\"fun\",\"dateCreated\":[2015,2,5],\"accountBalance\":200.0}]"));



        verify(transactionRepository, times(1)).findAll();
    }

    @Test
    public void getTransaction() throws Exception {
        when(transactionRepository.findById(24L)).thenReturn(java.util.Optional.ofNullable(stubTransactions().get(1)));
        when(transactionRepository.existsById(24L)).thenReturn(true);

        this.mvc.perform(MockMvcRequestBuilders
                .get("/transactions/24"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":24,\"type\":\"Fee\",\"amount\":123.45,\"account\":\"1\",\"comment\":\"fun\",\"dateCreated\":[2015,2,5],\"accountBalance\":200.0}"));
        verify(transactionRepository, times(1)).findById(24L);
        verify(transactionRepository, times(1)).existsById(24L);
    }

    @Test
    public void getTransactionsForAccount() throws Exception {
        when(transactionRepository.findTransactionByAccount_Id(1L)).thenReturn(Arrays.asList(stubTransactions().get(0),stubTransactions().get(1)));
        //when(accountRepository.existsById(24L)).thenReturn(true);
        //TODO: test account existence/verification

        this.mvc.perform(MockMvcRequestBuilders
                .get("/transactions/account/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("[{\"id\":23,\"type\":\"Fee\",\"amount\":123.45,\"account\":\"1\",\"comment\":\"fun\",\"dateCreated\":[2015,2,5],\"accountBalance\":200.0},{\"id\":24,\"type\":\"Fee\",\"amount\":123.45,\"account\":\"1\",\"comment\":\"fun\",\"dateCreated\":[2015,2,5],\"accountBalance\":200.0}]"));
        verify(transactionRepository, times(1)).findTransactionByAccount_Id(1L);
        //verify(transactionRepository, times(1)).existsById(24L);
    }

    @Test
    public void addTransaction() throws Exception {
        Account account1 = new Checking(1L,450.60,LocalDate.parse("2010-08-23"),null,"MyChecking");
        Transaction transaction1 = new Transaction(null,TransactionType.fromName("Fee"),123.45, account1, "fun", LocalDate.parse("2012-02-05"), 200.00);
        Transaction transaction2 = new Transaction(23L,TransactionType.fromName("Fee"),123.45, account1, "fun", LocalDate.parse("2012-02-05"), 200.00);
        String requestJson = "{\"id\":null,\"type\":\"Fee\",\"amount\":123.45,\"account\":\"1\",\"comment\":\"fun\",\"dateCreated\":\"2012-02-05\",\"accountBalance\":200.00}";

        when(transactionRepository.save(any(Transaction.class))).thenReturn(transaction2);
        when(accountRepository.existsById(1L)).thenReturn(true);
        when(accountRepository.findById(1L)).thenReturn(java.util.Optional.of(account1));

        this.mvc.perform(MockMvcRequestBuilders
                .post("/transactions")
                .contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":23,\"type\":\"Fee\",\"amount\":123.45,\"account\":\"1\",\"comment\":\"fun\",\"dateCreated\":[2012,2,5],\"accountBalance\":200.0}"));
        verify(accountRepository, times(2)).findById(1L);
        verify(transactionRepository, times(1)).save(any(Transaction.class));
    }

    @Test
    public void deleteTransaction() throws Exception {
        when(transactionRepository.existsById(23L)).thenReturn(true);

        this.mvc.perform(MockMvcRequestBuilders
                .delete("/transactions/23"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(transactionRepository, times(1)).deleteById(23L);
        verify(transactionRepository, times(1)).existsById(23L);
    }

    @Test
    public void deleteTransactionNotFound() throws Exception {

        when(transactionRepository.existsById(23L)).thenReturn(false);
        this.mvc.perform(MockMvcRequestBuilders
                .delete("/transactions/23"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

        verify(transactionRepository, times(0)).delete(stubTransactions().get(0));
        verify(transactionRepository, times(1)).existsById(23L);
    }
}
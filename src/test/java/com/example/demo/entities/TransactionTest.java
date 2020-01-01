package com.example.demo.entities;

import com.example.demo.enums.TransactionType;
import com.example.demo.repositories.TransactionRepository;
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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
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

@RunWith(MockitoJUnitRunner.class)
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
        Transaction transaction = new Transaction(234L, type, 123.45, null, "testaction", null, 456.78);
        String actual = mapper.writeValueAsString(transaction);

        String expected = "{\"id\":234,\"type\":\"Interest Earned\",\"amount\":123.45,\"account\":null,\"comment\":\"testaction\",\"dateCreated\":null,\"accountBalance\":456.78}";
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
        //Account account1 = new Checking();
        Transaction transaction1 = new Transaction(23L,TransactionType.fromName("Fee"),123.45, null, "fun", LocalDate.parse("2015-02-05"), 200.00);
        Transaction transaction2 = new Transaction(24L,TransactionType.fromName("Fee"),123.45, null, "fun", LocalDate.parse("2015-02-05"), 200.00);
        Transaction transaction3 = new Transaction(25L,TransactionType.fromName("Fee"),123.45, null, "fun", LocalDate.parse("2015-02-05"), 200.00);
        Transaction transaction4 = new Transaction(26L,TransactionType.fromName("Fee"),123.45, null, "fun", LocalDate.parse("2015-02-05"), 200.00);

        return Arrays.asList(transaction1,transaction2);
    }

    @Test
    public void getAllTransactions() throws Exception {
        when(transactionRepository.findAll()).thenReturn(stubTransactions());

        this.mvc.perform(MockMvcRequestBuilders
                .get("/transactions"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("[{\"id\":23,\"name\":\"Transaction A\",\"comps\":null},{\"id\":334,\"name\":\"Transaction B\",\"comps\":null}]"));

        verify(transactionRepository, times(1)).findAll();
    }
}
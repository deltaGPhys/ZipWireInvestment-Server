package com.example.demo.services;

import com.example.demo.entities.Investment;
import com.example.demo.entities.User;
import com.example.demo.repositories.InvestmentRepository;
import com.example.demo.repositories.SecurityHoldingRepository;
import com.example.demo.repositories.SecurityRepository;
import com.example.demo.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "test")
class InvestmentServiceTest {

    @MockBean
    private SecurityRepository securityRepository;
    @Autowired
    private InvestmentRepository investmentRepository;
    @MockBean
    private SecurityHoldingRepository securityHoldingRepository;
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private InvestmentService investmentService;
    @Autowired
    private AuthenticationService userService;

    @Autowired
    private MockMvc mvc;

    private User user;
    private User user2;
    private Investment inv1;
    private Investment inv2;
    private Investment inv3;

    @BeforeEach
    void setUp() throws Exception {
        user = new User("Zeke", "Freak", "email@email.com", "salty", null,100.00, 1000.00);
        user2 = new User("Zeke2", "Freak2", "email2@email.com", "salty", null,100.00, 1000.00);
//        userService.create(user);
//        userService.create(user2);
        inv1 = new Investment(123.45,LocalDate.parse("2019-01-02"), null, "test acct", null);

        inv2 = new Investment(4123.45,LocalDate.parse("2019-01-02"), null, "test acct", null);
        inv3 = new Investment(4123.45,LocalDate.parse("2019-01-02"), null, "test acct", null);
    }

    @AfterEach
    void tearDown() {
    }

//    @Test
//    void usersSave() throws Exception {
//        String expectedContent = "{\"id\":3,\"balance\":123.45,\"openingDate\":[2019,1,2],\"owner\":null,\"acctName\":\"test acct\",\"holdings\":null}";
//        this.mvc.perform(MockMvcRequestBuilders
//                .post("/investment")
//                .content("{\"balance\":123.45,\"openingDate\":\"2019-01-02\",\"owner\":null,\"acctName\":\"test acct\",\"holdings\":null}")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
//        System.out.println(investmentRepository.findById(1L));
//        System.out.println(investmentRepository.findById(2L));
//        System.out.println(investmentRepository.findById(3L));
//    }


//    @Test
//    void findInvestmentAcctById() throws Exception {
//        Long givenId = 2L;
////        BDDMockito
////                .given(investmentRepository.findById(givenId))
////                .willReturn(Optional.of(new Investment(2L, 123.45,LocalDate.parse("2019-01-02"), user, "test acct", null)));
//
//
//        String expectedContent = "{\"id\":2,\"balance\":123.45,\"openingDate\":[2019,1,2],\"owner\":{\"id\":1,\"firstName\":\"Zeke\",\"lastName\":\"Freak\",\"email\":\"email@email.com\",\"password\":\"salty\",\"accounts\":[null,null],\"rent\":100.0,\"salary\":1000.0},\"acctName\":\"test acct\",\"holdings\":null}";
//        this.mvc.perform(MockMvcRequestBuilders
//                .get("/investment/" + givenId))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
//
//    }

//    @Test
//    void getForUser() throws Exception {
//
////        BDDMockito
////                .given(investmentRepository.findById(2L))
////                .willReturn(Optional.of(inv1));
////        BDDMockito
////                .given(investmentRepository.findById(3L))
////                .willReturn(Optional.of(inv2));
////        BDDMockito
////                .given(investmentRepository.findById(4L))
////                .willReturn(Optional.of(inv3));
////        BDDMockito
////                .given(userRepository.findById(1L))
////                .willReturn(Optional.of(user));
//
//        String expectedContent = "{\"id\":1,\"balance\":123.45,\"openingDate\":[2019,1,2],\"owner\":null,\"acctName\":\"test acct\",\"holdings\":[]}";
//        this.mvc.perform(MockMvcRequestBuilders
//                .get("/investment/user/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
//
//    }

//    @Test
//    void createAccount() {
//    }
//
//    @Test
//    void getSecurity() {
//    }
//
//    @Test
//    void getSecurityHolding() {
//    }
//
//    @Test
//    void getSecurityHoldingsByUser() {
//    }
}
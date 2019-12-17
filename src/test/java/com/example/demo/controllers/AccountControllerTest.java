package com.example.demo.controllers;


import com.example.demo.controllers.*;
import com.example.demo.repositories.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class AccountControllerTest {
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    SavingsRepository savingsRepository;
//    @MockBean
//    CheckingRepository checkingRepository;
//    @MockBean
//    InvestmentRepository investmentRepository;
//    @MockBean
//    GoalAccountRepository goalAccountRepository;
//    @MockBean
//    UserRepository userRepository;
//
//    @Test
//    public void testGetCheckingAccount() throws Exception {
//        long givenId = 1L;
//        BDDMockito
//                .given(checkingRepository.findById(givenId))
//                .willReturn(Optional.of(new Checking()));
//
//        String expectedContent = "{\"id\":null,\"balance\":\"null,\",\"openingDate\":null,\"owner\":null, \"acctName\":null}";
//        this.mvc.perform(MockMvcRequestBuilders
//                .get("/checking/" + givenId))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
//    }
//
//    @Test
//    public void testGetSavingsAccount() throws Exception {
//        long givenId = 1L;
//        BDDMockito
//                .given(savingsRepository.findById(givenId))
//                .willReturn(Optional.of(new Savings()));
//
//        String expectedContent = "{\"id\":null,\"balance\":\"null,\",\"openingDate\":null,\"owner\":null, \"acctName\":null}";
//        this.mvc.perform(MockMvcRequestBuilders
//                .get("/checking/" + givenId))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
//    }
//
//    @Test
//    public void testGetInvestmentAccount() throws Exception {
//        long givenId = 1L;
//        BDDMockito
//                .given(investmentRepository.findById(givenId))
//                .willReturn(Optional.of(new Investment()));
//
//        String expectedContent = "{\"id\":null,\"balance\":\"null,\",\"openingDate\":null,\"owner\":null, \"acctName\":null}";
//        this.mvc.perform(MockMvcRequestBuilders
//                .get("/checking/" + givenId))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
//    }
//
//    @Test
//    public void testGetGoalAccount() throws Exception {
//        long givenId = 1L;
//        BDDMockito
//                .given(savingsRepository.findById(givenId))
//                .willReturn(Optional.of(new Savings()));
//
//        String expectedContent = "{\"id\":null,\"balance\":\"null,\",\"openingDate\":null,\"owner\":null, \"acctName\":null}";
//        this.mvc.perform(MockMvcRequestBuilders
//                .get("/checking/" + givenId))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
//    }
//
//    @Test
//    public void testCreateChecking() throws Exception {
//        Checking checking = new Checking();
//        BDDMockito
//                .given(checkingRepository.save(checking))
//                .willReturn(checking);
//
//        String expectedContent= "{\"id\":null,\"balance\":\"null,\",\"openingDate\":null,\"owner\":null, \"acctName\":null}";
//        this.mvc.perform(MockMvcRequestBuilders
//                .post("/checking/")
//                .content(expectedContent)
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON)
//        )
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
//    }
//
//    @Test
//    public void testCreateSavings() throws Exception {
//        Savings savings = new Savings();
//        BDDMockito
//                .given(savingsRepository.save(savings))
//                .willReturn(savings);
//
//        String expectedContent= "{\"id\":null,\"balance\":\"null,\",\"openingDate\":null,\"owner\":null, \"acctName\":null}";
//        this.mvc.perform(MockMvcRequestBuilders
//                .post("/checking/")
//                .content(expectedContent)
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON)
//        )
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
//    }
//
//    @Test
//    public void testCreateInvestments() throws Exception {
//        Investment investment = new Investment();
//        BDDMockito
//                .given(investmentRepository.save(investment))
//                .willReturn(investment);
//
//        String expectedContent= "{\"id\":null,\"balance\":\"null,\",\"openingDate\":null,\"owner\":null, \"acctName\":null}";
//        this.mvc.perform(MockMvcRequestBuilders
//                .post("/investment/")
//                .content(expectedContent)
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON)
//        )
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
//    }
//
//    @Test
//    public void testCreateGoalAccount() throws Exception {
//        GoalAccount goalAccount = new GoalAccount();
//        BDDMockito
//                .given(goalAccountRepository.save(goalAccount))
//                .willReturn(goalAccount);
//
//        String expectedContent= "{\"id\":null,\"balance\":\"null,\",\"openingDate\":null,\"owner\":null, \"acctName\":null}";
//        this.mvc.perform(MockMvcRequestBuilders
//                .post("/investment/")
//                .content(expectedContent)
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON)
//        )
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
//    }
//
//    @Test
//    public void testCloseChecking() throws Exception {}
//
//    @Test
//    public void testCloseSavings() throws Exception {}
//
//    @Test
//    public void testCloseInvestments() throws Exception {}
//
//    @Test
//    public void testCloseGoalAccount() throws Exception {}
//
//    @Test
//    public void testShowAllChecking() throws Exception {}
//
//    @Test
//    public void testShowAllSavings() throws Exception {}
//
//    @Test
//    public void testShowAllInvestments() throws Exception {}
//
//    @Test
//    public void testShowAllGoalAccounts() throws Exception {}
//
//    @Test
//    public void testGetSavingsAccountsForUser() throws Exception {}
//
//    @Test
//    public void testGetCheckingAccountsForUser() throws Exception {}
//
//    @Test
//    public void testGetInvestmentAccountsForUser() throws Exception {}
//
//    @Test
//    public void testGetGoalAccountsForUser() throws Exception {}
//
//
//
//
//
//


}

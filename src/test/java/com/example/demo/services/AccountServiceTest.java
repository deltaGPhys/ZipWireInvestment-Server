package com.example.demo.services;

//import com.example.demo.DemoApplication;
//import com.example.demo.controllers.*;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.BDDMockito;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import com.example.demo.entities.Checking;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.mockito.BDDMockito.given;
//import static org.mockito.BDDMockito.then;
//
//
//@RunWith(SpringRunner.class)
//    @ContextConfiguration(classes = DemoApplication.class)
//    public class AccountServiceTest {
//
//        @MockBean
//        private AccountService  service;
//
//        private AccountController controller;
//
//        @Before
//        public void setup(){
//            this.controller = new AccountController();
//        }
//
//        @Test
//        public void testCreateChecking() {
//            HttpStatus expected = HttpStatus.CREATED;
//            Checking expectedChecking = new Checking();
//            BDDMockito.given(service.createChecking(User, expectedChecking)).willReturn(expectedChecking);
//
//            ResponseEntity<Checking> response = controller.createChecking(User, expectedChecking);
//            HttpStatus actual = response.getStatusCode();
//            Checking actualCheckingAccount = response.getBody();
//
//            // Then
//            Assert.assertEquals(expected, actual);
//            Assert.assertEquals(expectedChecking, actualCheckingAccount);
//        }
//
//        @Test
//        public void testShowChecking() {
//            long checkingId = 1L;
//            HttpStatus expected = HttpStatus.OK;
//            Checking expectedChecking = new Checking();
//            BDDMockito.given(service.showAChecking(1L)).willReturn(user, expectedChecking);
//
//            ResponseEntity<Checking> response = controller.getCheckingAccount(owner, checkingId);
//            HttpStatus actual = response.getStatusCode();
//            Checking actualChecking = response.getBody();
//
//            Assert.assertEquals(expected, actual);
//            Assert.assertEquals(expectedChecking, actualChecking);
//        }
//


//}

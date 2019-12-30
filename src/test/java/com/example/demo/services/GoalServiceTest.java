package com.example.demo.services;

import com.example.demo.entities.SavingGoal;
import com.example.demo.repositories.SavingGoalRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.Mockito.*;


//@RunWith(MockitoJUnitRunner.class)
//public class GoalServiceTest {


//
//        @MockBean
//        private GoalService goalService;
//
//        @MockBean
//        private GoalController controller;
//
//        @Before
//        public void setup(){
//            //this.controller = new GoalController();
//        }
//
//
//        @Test
//        public void testCreate() {
//            // Given
//            HttpStatus expected = HttpStatus.CREATED;
//            SavingGoal expectedGoal = new SavingGoal();
//            given(goalService.createSavingGoal(expectedGoal)).willReturn(expectedGoal);
//
//            // When
//            ResponseEntity<SavingGoal> response = controller.createNewGoal(expectedGoal);
//            HttpStatus actual = response.getStatusCode();
//            SavingGoal actualGoal = response.getBody();
//
//            // Then
//            Assert.assertEquals(expected, actual);
//            Assert.assertEquals(expectedGoal, actualGoal);
//        }





//    @RunWith(MockitoJUnitRunner.class)
//    public class CarServiceTest {
//
//        @Mock
//        private SavingGoalRepository goalRepository;
//
//        @InjectMocks
//        private GoalService goalService;
//
//        @Test
//        public void findAllTest() {
//
//            when(goalService.findAllGoals()).thenReturn(stubGoalEntities());
//
//            goalService.findAllGoals();
//
//            verify(goalRepository, times(1)).findAll();
//        }
//
//        private Iterable<GoalEntity> stubGoalEntities() {
//
//            GoalEntity car = new GoalEntity("FORD", "F-150", "BLACK", 1975);
//            GoalEntity colorado = new CarEntity("CHEVY", "COLORADO", "SILVER", 1989);
//
//            return Arrays.asList(f150, colorado);
//        }
//
//        @Test
//        public void addNewGoalTest() {
//
//            GoalEntity expected = new CarEntity("TOYOTA", "TACOMA", "RED", 1996);
//            doReturn(expected).when(carRepository).save(any(CarEntity.class));
//
//            CarEntity actual = carService.addNewCar(stubAddNewCarRequest());
//
//            Assert.assertEquals(expected.toString(), actual.toString());
//        }
//
//        @Test
//        public void addNewCarWithNoReturnTest() {
//
//            CarEntity expected = new CarEntity("TOYOTA", "TACOMA", "RED", 1996);
//            doReturn(expected).when(goalRepository).save(any(GoalEntity.class));
//
//            goalService.addNewgoal(stubAddGoalCarRequest());
//
//            ArgumentCaptor<CarEntity> captor = ArgumentCaptor.forClass(CarEntity.class);
//            verify(carRepository, times(1)).save(captor.capture());
//
//            Assert.assertEquals(expected.toString(), captor.getValue().toString());
//        }
//
//        private AddNewGoalRequest stubAddNewCarRequest() {
//
//            AddNewGoalRequest addNewGoalRequest = new AddNewGoalRequest();
//            addNewCarRequest.setMake("TOYOTA");
//            addNewCarRequest.setModel("TACOMA");
//            addNewCarRequest.setColor("RED");
//            addNewCarRequest.setYear(1996);
//
//            return addNewCarRequest;
//        }
//
//    }
//



//        @Test
//        public void testShow() {
//            // Given
//            Long bakerId = 1L;
//            HttpStatus expected = HttpStatus.OK;
//            Muffin expectedMuffin = new Muffin();
//            given(service.show(1L)).willReturn(expectedMuffin);
//
//            // When
//            ResponseEntity<Muffin> response = controller.show(bakerId);
//            HttpStatus actual = response.getStatusCode();
//            Muffin actualMuffin = response.getBody();
//
//            // Then
//            Assert.assertEquals(expected, actual);
//            Assert.assertEquals(expectedMuffin, actualMuffin);
//        }
//    }
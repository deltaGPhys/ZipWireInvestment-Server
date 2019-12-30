package com.example.demo.services;


import com.example.demo.entities.SavingGoal;
import com.example.demo.entities.User;
import com.example.demo.entities.GoalAccount;
import com.example.demo.repositories.GoalAccountRepository;
import com.example.demo.repositories.SavingGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalService {

    @Autowired
    GoalAccountRepository goalAccountRepository;

    @Autowired
    SavingGoalRepository savingGoalRepository;

//    public Iterable<GoalAccount> findAllGoalAccounts() {
//        return goalAccountRepository.findAll();
//    }

    public Iterable<SavingGoal> findAllSavingGoals(User owner) {
        return savingGoalRepository.findAllByOwner(owner);
    }

    public Iterable<SavingGoal> findAllGoals() {
        return savingGoalRepository.findAll();
    }

//    public GoalAccount showUGoalAccount(long id) {
//        return goalAccountRepository.findById(id).get();
//    }

    public SavingGoal showSavingGoal(long id) {

        return savingGoalRepository.findById(id).get();
    }

//    public GoalAccount createGoalAccount(GoalAccount goalAccount) {
//        return goalAccountRepository.save(goalAccount);
//    }

    public SavingGoal createSavingGoal(SavingGoal savingGoal) {

        return savingGoalRepository.save(savingGoal);
    }

//    public GoalAccount updateGoalAccount (long id, User userToUpdate) {
//        User originalUser = userRepository.findById(id).get();
//        //return repository.save(originalUser);
//        return null;
//    }

    public SavingGoal updateSavingGoal(long id, User userToUpdate) {
        //User originalUser = userRepository.findById(id).get();
        //return repository.save(originalUser);
        return null;
    }

//    public boolean deleteGoalAccount(long id) {
//        goalAccountRepository.deleteById(id);
//        return true;
//    }

    public boolean deleteSavingGoal(long id) {
        savingGoalRepository.deleteById(id);
        return true;
    }

//    public GoalAccount existingGoalAcctCheck (long id) {
//        return null;
//    }

    public SavingGoal existingSavingGoalCheck (long id) {
        if (goalAccountRepository.findById(id).isPresent()){
            return savingGoalRepository.findById(id).get();
        }
        return null;
    }



}

package com.example.demo.services;


import com.example.demo.entities.SavingGoal;
import com.example.demo.entities.User;
import com.example.demo.entities.accounts.GoalAccount;
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

    public Iterable<GoalAccount> findAllGoalAccounts() {

        return goalAccountRepository.findAll();
    }

    public Iterable<SavingGoal> findAllSavingGoals() {

        return savingGoalRepository.findAll();
    }

    public GoalAccount showUGoalAccount(Long id) {
        return goalAccountRepository.findById(id).get();
    }

    public SavingGoal showSavingGoal(Long id) {
        return savingGoalRepository.findById(id).get();
    }

    public GoalAccount createGoalAccount(GoalAccount goalAccount) {
        return goalAccountRepository.save(goalAccount);
    }

    public SavingGoal createSavingGoal(SavingGoal savingGoal) {
        return savingGoalRepository.save(savingGoal);
    }

    public GoalAccount updateGoalAccount (Long id, User userToUpdate) {
        //User originalUser = userRepository.findById(id).get();
        //return repository.save(originalUser);
        return null;
    }

    public SavingGoal updateSavingGoal(Long id, User userToUpdate) {
        //User originalUser = userRepository.findById(id).get();
        //return repository.save(originalUser);
        return null;
    }

    public Boolean deleteGoalAccount(Long id) {
        goalAccountRepository.deleteById(id);
        return true;
    }
    public Boolean deleteSavingGoal(Long id) {
        savingGoalRepository.deleteById(id);
        return true;
    }

    public GoalAccount existingGoalAcctCheck (Long id) {
        return null;
    }

    public SavingGoal existingSavingGoalCheck (Long id) {
        return null;
    }



}

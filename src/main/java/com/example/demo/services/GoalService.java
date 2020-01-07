package com.example.demo.services;

import com.example.demo.entities.SavingGoal;
import com.example.demo.entities.User;
import com.example.demo.entities.GoalAccount;
import com.example.demo.repositories.AccountRepository;
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

    @Autowired
    AccountRepository accountRepository;

    public Iterable<SavingGoal> findAllSavingGoals(User owner) {
        return savingGoalRepository.findAllByOwner(owner);
    }

    public Iterable<SavingGoal> findAllGoals() {
        Iterable<SavingGoal> allGoals =  savingGoalRepository.findAll();
        return allGoals;
    }

    public Iterable<SavingGoal> showSavingGoalsForUser (long userId) {
       return savingGoalRepository.findAllByOwnerIdEquals(userId);
    }

//    public GoalAccount createGoalAccount(GoalAccount goalAccount) {
//        return goalAccountRepository.save(goalAccount);
//

    public SavingGoal createSavingGoal(SavingGoal savingGoal) {
        GoalAccount goalAccount = new GoalAccount();
        accountRepository.save(goalAccount);
        savingGoal.setAccount(goalAccount);
        return savingGoalRepository.save(savingGoal);
    }

//    public GoalAccount updateGoalAccount (long id, User userToUpdate) {
//        User originalUser = userRepository.findById(id).get();
//        //return repository.save(originalUser);
//        return null;
//    }

    public SavingGoal updateSavingGoal(long goalId, SavingGoal updatedSavingGoal) {
        SavingGoal savingGoal = getSavingGoalByGoalId(goalId);
        savingGoal.setGoalAmount(updatedSavingGoal.getGoalAmount());
        savingGoal.setOwner(updatedSavingGoal.getOwner());
        savingGoal.setAccount(updatedSavingGoal.getAccount());
        savingGoal.setEndDate(updatedSavingGoal.getEndDate());
        savingGoal.setDescription(updatedSavingGoal.getDescription());
        return savingGoalRepository.save(savingGoal);
    }

    public boolean deleteSavingGoal(long goalId) {
        savingGoalRepository.deleteById(goalId);
        return true;
    }

    public SavingGoal getSavingGoalByGoalId (long goalId){
        return savingGoalRepository.findById(goalId).get();
    }

}


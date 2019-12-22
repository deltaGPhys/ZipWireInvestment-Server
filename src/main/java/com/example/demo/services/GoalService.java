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
        if (savingGoalRepository.findById(id).isPresent()){
            return savingGoalRepository.findById(id).get();
        }
        return null;
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

    public SavingGoal updateSavingGoal(long id, SavingGoal updatedSavingGoal) {
        SavingGoal savingGoal = showSavingGoal(id);
        savingGoal.setGoalAmount(updatedSavingGoal.getGoalAmount());
        savingGoal.setOwner(updatedSavingGoal.getOwner());
        savingGoal.setAccount(updatedSavingGoal.getAccount());
        savingGoal.setEndDate(updatedSavingGoal.getEndDate());
        savingGoal.setDescription(updatedSavingGoal.getDescription());
        return savingGoalRepository.save(savingGoal);
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


}

package com.wendy.translators.impl;

import com.wendy.domain.dtos.PersonTransactionsDTO;
import com.wendy.domain.dtos.TypeAccountDTO;
import com.wendy.domain.persistence.Person;
import com.wendy.domain.persistence.PersonTransactions;
import com.wendy.domain.persistence.TypeAccount;
import com.wendy.repository.persistence.PersonRepo;
import com.wendy.repository.persistence.PersonTransactionsRepo;
import com.wendy.repository.persistence.TypeAccountRepo;
import com.wendy.translators.PersonTransactionsTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class PersonTransactionsTranslatorImpl implements PersonTransactionsTranslator {
    private PersonTransactionsRepo personTransactionsRepo;
    private PersonRepo personRepo;
    private TypeAccountRepo typeAccountRepo;

    @Autowired
    public PersonTransactionsTranslatorImpl(PersonTransactionsRepo personTransactionsRepo, PersonRepo personRepo, TypeAccountRepo typeAccountRepo) {
        this.personTransactionsRepo = personTransactionsRepo;
        this.personRepo = personRepo;
        this.typeAccountRepo = typeAccountRepo;
    }


    @Override
    public List<PersonTransactionsDTO> getmemberTransaction(String email) {
        List<PersonTransactionsDTO> allusertransactions = new ArrayList<>();
        try {
            for (PersonTransactions account:personTransactionsRepo.getUserTransactions(email)){
                allusertransactions.add(new PersonTransactionsDTO(account));
            }
        }catch (Exception e){
            throw new RuntimeException("Cannot get the user transactions",e);
        }
        return allusertransactions;
    }

    @Override
    public void deleteMemberTransaction(String email) {
        try {
            personTransactionsRepo.deleteUserTransactions(email);
        }catch (Exception e){
            throw new RuntimeException("Cannot delete the user transactions",e);
        }
    }

    @Override
    public PersonTransactionsDTO addTransaction(PersonTransactionsDTO personTransactionsDTO) {
        Person person;
        TypeAccount account;
        PersonTransactions personTransactions;
        try {
            person = personRepo.getUserByEmail(personTransactionsDTO.getPerson().getEmail());
            account = typeAccountRepo.getAccountType(personTransactionsDTO.getTypeAccount().getNmonic());
            personTransactions = personTransactionsDTO.buildTransaction(account,person);
            personTransactionsRepo.save(personTransactions);
        }catch (Exception e){
            throw new RuntimeException("Cannot get the user transactions",e);
        }
        return null;
    }
}

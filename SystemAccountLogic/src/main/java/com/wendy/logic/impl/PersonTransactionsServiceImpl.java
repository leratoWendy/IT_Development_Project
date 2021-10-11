package com.wendy.logic.impl;

import com.wendy.domain.dtos.PersonTransactionsDTO;
import com.wendy.logic.PersonTransactionsService;
import com.wendy.translators.PersonTransactionsTranslator;
import com.wendy.translators.PersonTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class PersonTransactionsServiceImpl implements PersonTransactionsService {
    private PersonTransactionsTranslator personTransactionsService;

    @Autowired
    public PersonTransactionsServiceImpl(PersonTransactionsTranslator personTransactionsService) {
        this.personTransactionsService = personTransactionsService;
    }

    @Override
    public List<PersonTransactionsDTO> getmemberTransaction(String email) {
        return personTransactionsService.getmemberTransaction(email);
    }

    @Override
    public void deleteMemberTransaction(String email) {
        personTransactionsService.deleteMemberTransaction(email);
    }

    @Override
    public PersonTransactionsDTO addTransaction(PersonTransactionsDTO personTransactionsDTO) {
        return personTransactionsService.addTransaction(personTransactionsDTO);
    }
}

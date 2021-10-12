package com.wendy.translators;

import com.wendy.domain.dtos.PersonTransactionsDTO;
import com.wendy.domain.dtos.TypeAccountDTO;

import java.util.List;

public interface PersonTransactionsTranslator {
    List<PersonTransactionsDTO> getmemberTransaction(String email);
    void deleteMemberTransaction(String email);
    PersonTransactionsDTO addTransaction(PersonTransactionsDTO personTransactionsDTO);
    public void updateAmount (String email, PersonTransactionsDTO personTransactionsDTO);
}

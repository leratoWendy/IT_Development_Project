package com.wendy.logic;

import com.wendy.domain.dtos.PersonTransactionsDTO;

import java.util.List;

public interface PersonTransactionsService {
    List<PersonTransactionsDTO> getmemberTransaction(String email);
    void deleteMemberTransaction(String email);
    PersonTransactionsDTO addTransaction(PersonTransactionsDTO personTransactionsDTO);
}

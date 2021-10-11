package com.wendy.logic;

import com.wendy.domain.dtos.TypeAccountDTO;

import java.util.List;

public interface TypeAccountService {
    List<TypeAccountDTO> getAccountTypes();
    void deleteAccountType(String nmonic);
    TypeAccountDTO getTypeAccount(String nmonic);
    TypeAccountDTO addTypeAccount(TypeAccountDTO typeAccountDTO);
}

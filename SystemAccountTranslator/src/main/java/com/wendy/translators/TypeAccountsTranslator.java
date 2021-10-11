package com.wendy.translators;

import com.wendy.domain.dtos.TypeAccountDTO;
import java.util.*;

public interface TypeAccountsTranslator {
    List<TypeAccountDTO> getAccountTypes();
    void deleteAccountType(String nmonic);
    TypeAccountDTO getTypeAccount(String nmonic);
    TypeAccountDTO addTypeAccount(TypeAccountDTO typeAccountDTO);
}

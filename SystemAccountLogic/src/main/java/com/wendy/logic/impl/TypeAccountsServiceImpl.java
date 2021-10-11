package com.wendy.logic.impl;

import com.wendy.domain.dtos.TypeAccountDTO;
import com.wendy.logic.TypeAccountService;
import com.wendy.translators.TypeAccountsTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class TypeAccountsServiceImpl implements TypeAccountService {
    private TypeAccountsTranslator typeAccountsTranslator;

    @Autowired
    public TypeAccountsServiceImpl(TypeAccountsTranslator typeAccountsTranslator) {
        this.typeAccountsTranslator = typeAccountsTranslator;
    }

    @Override
    public List<TypeAccountDTO> getAccountTypes() {
        return typeAccountsTranslator.getAccountTypes();
    }

    @Override
    public void deleteAccountType(String nmonic) {
        typeAccountsTranslator.deleteAccountType(nmonic);
    }

    @Override
    public TypeAccountDTO getTypeAccount(String nmonic) {
        return typeAccountsTranslator.getTypeAccount(nmonic);
    }

    @Override
    public TypeAccountDTO addTypeAccount(TypeAccountDTO typeAccountDTO) {
        return typeAccountsTranslator.addTypeAccount(typeAccountDTO);
    }
}

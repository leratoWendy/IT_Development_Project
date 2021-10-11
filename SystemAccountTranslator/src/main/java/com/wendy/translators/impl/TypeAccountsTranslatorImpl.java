package com.wendy.translators.impl;

import com.wendy.domain.dtos.RewardsDTO;
import com.wendy.domain.dtos.TypeAccountDTO;
import com.wendy.domain.persistence.Rewards;
import com.wendy.domain.persistence.TypeAccount;
import com.wendy.repository.persistence.TypeAccountRepo;
import com.wendy.translators.TypeAccountsTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class TypeAccountsTranslatorImpl implements TypeAccountsTranslator {
    private TypeAccountRepo typeAccountRepo;

    @Autowired
    public TypeAccountsTranslatorImpl(TypeAccountRepo typeAccountRepo) {
        this.typeAccountRepo = typeAccountRepo;
    }

    @Override
    public List<TypeAccountDTO> getAccountTypes() {
        List<TypeAccountDTO> allaccountTypes = new ArrayList<>();
        try {
            for (TypeAccount account: typeAccountRepo.findAll()){
                allaccountTypes.add(new TypeAccountDTO(account));
            }
        }catch (Exception e){
            throw new RuntimeException("Cannot get The account types",e);
        }
        return allaccountTypes;
    }

    @Override
    public void deleteAccountType(String nmonic) {
        try {
            typeAccountRepo.deleteByNmonic(nmonic);
        }catch (Exception e){
            throw new RuntimeException("Cannot get delete account type",e);
        }
    }

    @Override
    public TypeAccountDTO getTypeAccount(String nmonic) {
        TypeAccountDTO accountDTO;
        try {
            accountDTO = new TypeAccountDTO(typeAccountRepo.getAccountType(nmonic));
        }catch (Exception e){
            throw new RuntimeException("Cannot get The account type",e);
        }
        return accountDTO;
    }

    @Override
    public TypeAccountDTO addTypeAccount(TypeAccountDTO typeAccountDTO) {
        TypeAccount account;
        try {
            account = typeAccountDTO.buildTypeaccount(typeAccountDTO);
            typeAccountRepo.save(account);
        }catch (Exception e){
            throw new RuntimeException("Cannot save The account type",e);
        }
        return new TypeAccountDTO(account);
    }
}

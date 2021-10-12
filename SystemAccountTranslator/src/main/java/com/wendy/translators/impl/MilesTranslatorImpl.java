package com.wendy.translators.impl;

import com.wendy.domain.dtos.MilesDto;
import com.wendy.domain.dtos.PersonDto;
import com.wendy.domain.persistence.Miles;
import com.wendy.domain.persistence.Person;
import com.wendy.repository.persistence.MilesRepo;
import com.wendy.repository.persistence.PersonRepo;
import com.wendy.repository.persistence.TypeAccountRepo;
import com.wendy.translators.MilesTranslator;
import com.wendy.translators.PersonTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class MilesTranslatorImpl implements MilesTranslator {
    private MilesRepo milesRepo;
    private PersonRepo personRepo;

    @Autowired
    public MilesTranslatorImpl(MilesRepo milesRepo, PersonRepo personRepo) {
        this.milesRepo = milesRepo;
        this.personRepo = personRepo;
    }




    @Override
    public List<MilesDto> getAllMiles() {
        List<MilesDto> allmiles = new ArrayList<>();
        try {
            for (Miles miles: milesRepo.findAll()){
                allmiles.add(new MilesDto(miles));
            }
        }catch (Exception e){
            throw new RuntimeException("Cannot get The miles",e);
        }
        return allmiles;
    }

    @Override
    public MilesDto getMemberMiles(String email) {
        Miles miles;
        try {
            miles = milesRepo.getMemberMiles(email);
        }catch (Exception e){
            throw new RuntimeException("Cannot get The miles",e);
        }
        return new MilesDto(miles);
    }

    @Override
    public MilesDto addMiles(PersonDto milesDto) {
        MilesDto miles = milesDto.getMilesDto();
        Miles membermiles;
        try {
            Person person = personRepo.getUserByEmail(milesDto.getEmail());
            membermiles = miles.buildMiles(person);
            milesRepo.save(membermiles);
        }catch (Exception e){
            throw new RuntimeException("Cannot add The miles",e);
        }
        return new MilesDto(membermiles);
    }

    @Override
    public MilesDto deleteMiles(String email) {
        Miles miles;
        try {
            miles = milesRepo.getMemberMiles(email);
            milesRepo.deleteMilesForUser(email);
        }catch (Exception e){
            throw new RuntimeException("Cannot add The miles",e);
        }
        return new MilesDto(miles);
    }
}

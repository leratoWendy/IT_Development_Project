package com.wendy.translators.impl;

import com.wendy.domain.dtos.MilesDto;
import com.wendy.domain.dtos.PersonDto;
import com.wendy.domain.persistence.Miles;
import com.wendy.domain.persistence.Person;
import com.wendy.repository.persistence.MilesRepo;
import com.wendy.repository.persistence.PersonRepo;
import com.wendy.translators.PersonTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class PersonTranslatorImpl implements PersonTranslator {
    private PersonRepo personRepo;
    private MilesRepo milesRepo;

    @Autowired
    public PersonTranslatorImpl(PersonRepo personRepo, MilesRepo milesRepo) {
        this.personRepo = personRepo;
        this.milesRepo = milesRepo;
    }


    @Override
    public List<PersonDto> getAllMembers() {
        List<PersonDto> allmembers = new ArrayList<>();
        try {
            for (Person miles: personRepo.findAll()){
                allmembers.add(new PersonDto(miles));
            }
        }catch (Exception e){
            throw new RuntimeException("Cannot get The members",e);
        }
        return allmembers;
    }

    @Override
    public PersonDto getMember(String email) {
        Person person;
        try {
           person = personRepo.getUserByEmail(email);
        }catch (Exception e){
            throw new RuntimeException("Cannot get The member with that email",e);
        }
        return new PersonDto(person);
    }

    @Override
    public PersonDto deleteMember(String email) {
        Person person;
        try {
            person = personRepo.getUserByEmail(email);
            personRepo.delete(person);
        }catch (Exception e){
            throw new RuntimeException("Cannot delete the member by email",e);
        }
        return new PersonDto(person);
    }

    @Override
    public PersonDto addMember(PersonDto personDto) {
        Person person;
        try {
            person = personDto.buildPerson(personDto);
            Person save = personRepo.save(person);
            //milesRepo.save(save.getMiles());
        }catch (Exception e){
            throw new RuntimeException("Cannot add the member",e);
        }
        return new PersonDto(person);
    }
}

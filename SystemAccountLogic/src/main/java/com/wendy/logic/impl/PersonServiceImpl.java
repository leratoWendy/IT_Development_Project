package com.wendy.logic.impl;

import com.wendy.domain.dtos.PersonDto;
import com.wendy.logic.PersonService;
import com.wendy.translators.PersonTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class PersonServiceImpl implements PersonService {
    private PersonTranslator personTranslator;

    @Autowired
    public PersonServiceImpl(PersonTranslator personTranslator) {
        this.personTranslator = personTranslator;
    }

    @Override
    public List<PersonDto> getAllMembers() {
        return personTranslator.getAllMembers();
    }

    @Override
    public PersonDto getMember(String email) {
        return personTranslator.getMember(email);
    }

    @Override
    public PersonDto deleteMember(String email) {
        return personTranslator.deleteMember(email);
    }

    @Override
    public PersonDto addMember(PersonDto personDto) {

        return personTranslator.addMember(personDto);

    }
}

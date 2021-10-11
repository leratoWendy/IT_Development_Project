package com.wendy.logic;

import com.wendy.domain.dtos.PersonDto;

import java.util.List;

public interface PersonService {
    List<PersonDto> getAllMembers();
    PersonDto getMember(String email);
    PersonDto deleteMember(String email);
    PersonDto addMember(PersonDto personDto);
}

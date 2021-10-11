package com.wendy.translators;

import com.wendy.domain.dtos.PersonDto;
import java.util.*;

public interface PersonTranslator {
    List<PersonDto> getAllMembers();
    PersonDto getMember(String email);
    PersonDto deleteMember(String email);
    PersonDto addMember(PersonDto personDto);
}

package com.wendy.translators;

import com.wendy.domain.dtos.MilesDto;
import com.wendy.domain.dtos.PersonDto;
import com.wendy.domain.persistence.Miles;
import java.util.*;

public interface MilesTranslator {
    List<MilesDto> getAllMiles();
    MilesDto getMemberMiles(String email);
    MilesDto addMiles(PersonDto milesDto);
    MilesDto deleteMiles(String email);
}

package com.wendy.logic;

import com.wendy.domain.dtos.MilesDto;
import com.wendy.domain.dtos.PersonDto;

import java.util.List;

public interface MilesService {
    List<MilesDto> getAllMiles();
    MilesDto getMemberMiles(String email);
    MilesDto addMiles(PersonDto milesDto);
    MilesDto deleteMiles(String email);
}

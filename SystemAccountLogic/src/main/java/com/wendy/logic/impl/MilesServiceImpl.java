package com.wendy.logic.impl;

import com.wendy.domain.dtos.MilesDto;
import com.wendy.domain.dtos.PersonDto;
import com.wendy.logic.MilesService;
import com.wendy.translators.MilesTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class MilesServiceImpl implements MilesService {
    private MilesTranslator milesTranslator;

    @Autowired
    public MilesServiceImpl(MilesTranslator milesTranslator) {
        this.milesTranslator = milesTranslator;
    }

    @Override
    public List<MilesDto> getAllMiles() {
        return milesTranslator.getAllMiles();
    }

    @Override
    public MilesDto getMemberMiles(String email) {
        return milesTranslator.getMemberMiles(email);
    }

    @Override
    public MilesDto addMiles(PersonDto milesDto) {
        return milesTranslator.addMiles(milesDto);
    }

    @Override
    public MilesDto deleteMiles(String email) {
        return milesTranslator.deleteMiles(email);
    }
}

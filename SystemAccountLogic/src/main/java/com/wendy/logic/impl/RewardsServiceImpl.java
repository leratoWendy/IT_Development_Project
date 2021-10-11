package com.wendy.logic.impl;

import com.wendy.domain.dtos.RewardsDTO;
import com.wendy.logic.RewardsService;
import com.wendy.translators.RewardsTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class RewardsServiceImpl implements RewardsService {
    private RewardsTranslator translator;

    @Autowired
    public RewardsServiceImpl(RewardsTranslator translator) {
        this.translator = translator;
    }

    @Override
    public List<RewardsDTO> getAllRewards() {
        return translator.getAllRewards();
    }

    @Override
    public RewardsDTO updateReward(Long id, int price) {
        return translator.updateReward(id,price);
    }

    @Override
    public RewardsDTO deleteReward(Long id) {
        return translator.deleteReward(id);
    }

    @Override
    public RewardsDTO addReward(RewardsDTO rewardsDTO) {
        return translator.addReward(rewardsDTO);
    }
}

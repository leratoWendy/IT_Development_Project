package com.wendy.translators.impl;

import com.wendy.domain.dtos.PersonDto;
import com.wendy.domain.dtos.RewardsDTO;
import com.wendy.domain.persistence.Person;
import com.wendy.domain.persistence.Rewards;
import com.wendy.repository.persistence.RewardsRepo;
import com.wendy.translators.RewardsTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class RewardsTranslatorImpl implements RewardsTranslator {
    private RewardsRepo rewardsRepo;

    @Autowired
    public RewardsTranslatorImpl(RewardsRepo rewardsRepo) {
        this.rewardsRepo = rewardsRepo;
    }

    @Override
    public List<RewardsDTO> getAllRewards() {
        List<RewardsDTO> allrewards = new ArrayList<>();
        try {
            for (Rewards rewards: rewardsRepo.findAll()){
                allrewards.add(new RewardsDTO(rewards));
            }
        }catch (Exception e){
            throw new RuntimeException("Cannot get The rewards",e);
        }
        return allrewards;
    }

    @Override
    public RewardsDTO updateReward(Long id, int price) {
        Rewards rewards;
        try {
            rewardsRepo.updateReward(id,price);
            rewards = rewardsRepo.getOne(id);
        }catch (Exception e){
            throw new RuntimeException("Cannot update the reward",e);
        }
        return new RewardsDTO(rewards);
    }

    @Override
    public RewardsDTO deleteReward(Long id) {
        Rewards rewards;
        try {
            rewards = rewardsRepo.getOne(id);
            rewardsRepo.delete(rewards);
        }catch (Exception e){
            throw new RuntimeException("Cannot delete the reward",e);
        }
        return new RewardsDTO(rewards);
    }

    @Override
    public RewardsDTO addReward(RewardsDTO rewardsDTO) {
        Rewards rewards;
        try {
            rewards = rewardsDTO.buildRewards(rewardsDTO);
            rewardsRepo.save(rewards);
        }catch (Exception e){
            throw new RuntimeException("Cannot add the reward",e);
        }
        return new RewardsDTO(rewards);
    }
}

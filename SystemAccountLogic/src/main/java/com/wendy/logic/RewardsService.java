package com.wendy.logic;

import com.wendy.domain.dtos.RewardsDTO;

import java.util.List;

public interface RewardsService {
    List<RewardsDTO> getAllRewards();
    RewardsDTO updateReward(Long id,int price);
    RewardsDTO deleteReward(Long id);
    RewardsDTO addReward(RewardsDTO rewardsDTO);
}

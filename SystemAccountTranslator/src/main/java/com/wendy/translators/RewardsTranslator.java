package com.wendy.translators;

import com.wendy.domain.dtos.RewardsDTO;
import  java.util.*;

public interface RewardsTranslator {
    List<RewardsDTO> getAllRewards();
    RewardsDTO updateReward(Long id,int price);
    RewardsDTO deleteReward(Long id);
    RewardsDTO addReward(RewardsDTO rewardsDTO);
}

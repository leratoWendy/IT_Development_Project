package com.wendy.repository.persistence;

import com.wendy.domain.persistence.Rewards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface RewardsRepo extends JpaRepository<Rewards,Long> {
    @Transactional
    @Modifying
    @Query(value = "update rewards set reward_price=:price where reward_id=:id",nativeQuery = true)
    void updateReward(@Param("id") Long id,@Param("price") int price);
}

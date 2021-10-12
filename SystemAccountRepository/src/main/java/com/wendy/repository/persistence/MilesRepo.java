package com.wendy.repository.persistence;

import com.wendy.domain.persistence.Miles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MilesRepo extends JpaRepository<Miles, Long> {
    @Transactional
    @Modifying
    @Query(value = "delete from miles join persons on miles.person_id=persons.person_id where persons.email=:email",nativeQuery = true)
    void deleteMilesForUser(@Param("email") String email);

    @Query(value = "select * from miles join persons on miles.person_id=persons.person_id where persons.email=:email",nativeQuery = true)
    Miles getMemberMiles(String email);

    @Transactional
    @Modifying
    @Query(value = "update miles set miles=:amount where miles.person_id in(" +
            "select person_id from persons where email=:email)",nativeQuery = true)
    void updateMyAmount(@Param("email") String email,@Param("amount") int cur_amount);
}

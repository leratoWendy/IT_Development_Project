package com.wendy.repository.persistence;

import com.wendy.domain.persistence.Miles;
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
    @Query(value = "delete from miles join persons on miles.person_id=person.person_id where persons.email=:email",nativeQuery = true)
    Miles deleteMilesForUser(@Param("email") String email);


    @Transactional
    @Modifying
    @Query(value = "select * from miles join persons on miles.person_id=person.person_id where persons.email=:email",nativeQuery = true)
    Miles getMemberMiles(String email);
}

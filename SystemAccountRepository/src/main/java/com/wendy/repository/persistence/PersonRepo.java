package com.wendy.repository.persistence;

import com.wendy.domain.persistence.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long>{
    @Transactional
    @Modifying
    @Query(value = "select * from persons where persons.email=:email",nativeQuery = true)
    Person getUserByEmail(String email);
}


package com.wendy.repository.persistence;

import com.wendy.domain.persistence.PersonTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;

@Repository
public interface PersonTransactionsRepo extends JpaRepository<PersonTransactions, Long> {
    @Transactional
    @Modifying
    @Query(value = "delete from Person_Transactions join persons on Person_Transactions.person_id=persons.person_id where persons.email=:email",nativeQuery = true)
    void deleteUserTransactions(String email);

    @Transactional
    @Modifying
    @Query(value = "select * from Person_Transactions join persons on Person_Transactions.person_id=persons.person_id where persons.email=:email",nativeQuery = true)
    List<PersonTransactions> getUserTransactions(String email);
}

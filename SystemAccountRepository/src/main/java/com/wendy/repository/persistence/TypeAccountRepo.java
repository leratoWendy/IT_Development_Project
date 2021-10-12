package com.wendy.repository.persistence;

import com.wendy.domain.dtos.TypeAccountDTO;
import com.wendy.domain.persistence.TypeAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TypeAccountRepo extends JpaRepository<TypeAccount, Long> {

    @Query(value = "select * from account_types where nmonic=:nmonic",nativeQuery = true)
    TypeAccount getAccountType(@Param("nmonic") String nmonic);


    @Transactional
    @Modifying
    @Query(value = "delete from account_types where nmonic=:nmonic",nativeQuery = true)
    void deleteByNmonic(@Param("nmonic") String nmonic);
}

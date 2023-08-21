package com.milagro.springmoneytransferservice.repository;

import com.milagro.springmoneytransferservice.model.MTSOperation;
import com.milagro.springmoneytransferservice.model.MTSUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MTSUserRepository extends JpaRepository<MTSUser, Long> {
    List<MTSUser> findByCardFromNumber(String cardFromNumber);
    List<MTSUser> findByAccessCode(String accessCode);

}

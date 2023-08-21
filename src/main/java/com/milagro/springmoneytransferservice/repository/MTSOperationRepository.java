package com.milagro.springmoneytransferservice.repository;

import com.milagro.springmoneytransferservice.model.MTSOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MTSOperationRepository extends JpaRepository<MTSOperation, Long> {
    List<MTSOperation> findByCardFromNumber(String cardFromNumber);
    List<MTSOperation> findByCardToNumber(String cardToNumber);
}

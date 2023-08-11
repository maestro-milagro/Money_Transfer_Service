package com.milagro.springmoneytransferservice.repository;

import com.milagro.springmoneytransferservice.model.MTSOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MTSOperationRepository extends JpaRepository<MTSOperation, Long> {
    
}

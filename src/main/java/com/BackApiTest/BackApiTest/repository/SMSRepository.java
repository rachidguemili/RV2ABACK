package com.BackApiTest.BackApiTest.repository;

import com.BackApiTest.BackApiTest.entity.SMS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SMSRepository extends JpaRepository<SMS, Long> {
}

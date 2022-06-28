package com.example.demo_customvalidation.repository;

import com.example.demo_customvalidation.model.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber,Long> {
}

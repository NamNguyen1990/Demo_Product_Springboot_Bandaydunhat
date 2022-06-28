package com.example.demo_customvalidation.service;

import com.example.demo_customvalidation.model.PhoneNumber;
import com.example.demo_customvalidation.repository.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhoneNumberImpl implements PhoneNumberService {
    @Autowired
    PhoneNumberRepository phoneNumberRepository;

    @Override
    public Iterable<PhoneNumber> findAll() {
        return phoneNumberRepository.findAll();
    }

    @Override
    public Optional<PhoneNumber> findById(Long id) {
        return phoneNumberRepository.findById(id);
    }

    @Override
    public PhoneNumber save(PhoneNumber phoneNumber) {
        return phoneNumberRepository.save(phoneNumber);
    }

    @Override
    public void remove(Long id) {
        phoneNumberRepository.deleteById(id);

    }
}

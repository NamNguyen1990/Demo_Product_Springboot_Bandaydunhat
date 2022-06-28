package com.example.demo_customvalidation.controller;


import com.example.demo_customvalidation.model.PhoneNumber;
import com.example.demo_customvalidation.service.PhoneNumberImpl;
import com.example.demo_customvalidation.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class PhoneRestNumber {
    @Autowired
    PhoneNumberImpl phoneNumberService;

    @GetMapping
    public ResponseEntity<Iterable<PhoneNumber>> findAllPhoneNumber() {
        List<PhoneNumber> phoneNumbers = (List<PhoneNumber>) phoneNumberService.findAll();
        if (phoneNumbers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(phoneNumbers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PhoneNumber> savePost (@Valid @RequestBody PhoneNumber phoneNumber) {
        return new ResponseEntity<>(phoneNumberService.save(phoneNumber), HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}

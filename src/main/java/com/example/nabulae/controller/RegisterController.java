package com.example.nabulae.controller;

import com.example.nabulae.DAO.RegisterDAO;
import com.example.nabulae.services.NabulaeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/register")
@CrossOrigin(origins = "*")
public class RegisterController {
    private final NabulaeService service;

    @Autowired
    public RegisterController(NabulaeService service) {
        this.service = service;
    }


    @PostMapping("/new")
    public ResponseEntity<HttpStatus> userRegister(@RequestBody RegisterDAO user) throws Exception {
        return service.userRegister(Optional.of(user));
    }
}

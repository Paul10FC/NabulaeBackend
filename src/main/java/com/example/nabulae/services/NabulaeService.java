package com.example.nabulae.services;

import com.example.nabulae.DAO.RegisterDAO;
import com.example.nabulae.repository.RegisterRepository;
import com.example.nabulae.utils.RegisterUserUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NabulaeService {

    private final RegisterRepository repository;
    private final Logger logger;

    @Autowired
    public NabulaeService(RegisterRepository repository) {
        this.repository = repository;
        this.logger = org.slf4j.LoggerFactory.getLogger(NabulaeService.class);
    }

    public ResponseEntity<HttpStatus> userRegister(Optional<RegisterDAO> user) throws Exception {
        if (user.isPresent()){
            boolean isValidParams = RegisterUserUtils.isValidParams(user.get());

            if (!isValidParams) {
                logger.error("El usuario no se ha registrado debido a un faltante de datos");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            try {
                repository.save(user.get());
                logger.info("El usuario: " + user.get().getName() + " se ha registrado correctamente");
                return new ResponseEntity<>(HttpStatus.CREATED);
            } catch (Exception e) {
                logger.error("Ha ocurrido un error de servidor");
            }
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

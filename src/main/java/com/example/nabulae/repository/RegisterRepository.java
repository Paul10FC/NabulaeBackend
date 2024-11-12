package com.example.nabulae.repository;

import com.example.nabulae.DAO.RegisterDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterDAO, Long> {
}

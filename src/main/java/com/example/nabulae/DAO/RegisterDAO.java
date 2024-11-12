package com.example.nabulae.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity(name = "users")
@ToString
public class RegisterDAO {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String message;
    private String location;
}

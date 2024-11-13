package com.example.nabulae.utils;

import com.example.nabulae.DAO.RegisterDAO;

public class RegisterUserUtils {
    public static boolean isValidParams(RegisterDAO user) {
        boolean isValidName = user.getName() != null && !user.getName().isEmpty();
        boolean isValidEmail = user.getEmail() != null && !user.getEmail().isEmpty();
        boolean isValidMessage = user.getMessage() != null && !user.getMessage().isEmpty();
        boolean isValidLocation = user.getLocation() != null && !user.getLocation().isEmpty();

        return isValidName && isValidEmail && isValidMessage && isValidLocation;
    }
}

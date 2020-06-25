package com.example.exceptionhandling.services;

import com.example.exceptionhandling.exceptions.ApplicationException;
import com.example.exceptionhandling.exceptions.NoDataFoundException;
import com.example.exceptionhandling.exceptions.ValidationException;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    public String demo(int num) {


        if (num == 10) {
            throw new NoDataFoundException("No Data Found");
        }

        if (num == 20) {
            throw new ValidationException("Validation Error");
        }

        if (num == 30) {
            throw new ApplicationException("Database configurations are missing. " +
                    "Cannot start application");
        }



        if (num == 1) {
            "".charAt(2);
        }

        if (num == 2) {
            String myVal = null;
            myVal.trim();
        }

        if (num == 3) {
            throw new RuntimeException("Relax. This is a demo");
        }

        return "All is fine with - " + num;
    }
}

package org.avi1606.ubetprojectauthservices.controllers;

import org.avi1606.ubetprojectauthservices.dto.PassengerDTO;
import org.avi1606.ubetprojectauthservices.dto.PassengerSignupDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    @PostMapping("signup/passenger")
    public ResponseEntity<PassengerDTO> signup(@RequestBody PassengerSignupDTO passengerSignupDTO) {

        return null;
    }
}

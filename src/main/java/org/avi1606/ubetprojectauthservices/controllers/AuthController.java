package org.avi1606.ubetprojectauthservices.controllers;

import lombok.AllArgsConstructor;
import org.avi1606.ubetprojectauthservices.dto.PassengerDTO;
import org.avi1606.ubetprojectauthservices.dto.PassengerSignupDTO;
import org.avi1606.ubetprojectauthservices.models.Passenger;
import org.avi1606.ubetprojectauthservices.services.AuthServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthServices authServices;

    @PostMapping("signup/passenger")
    public ResponseEntity<PassengerDTO> signup(@RequestBody PassengerSignupDTO passengerSignupDTO) {
        PassengerDTO response = authServices.signupPassenger(passengerSignupDTO);
        return new ResponseEntity<>(response , HttpStatus.CREATED);
    }
}

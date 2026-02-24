package org.avi1606.ubetprojectauthservices.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.avi1606.ubetprojectauthservices.dto.AuthRequestDTO;
import org.avi1606.ubetprojectauthservices.dto.PassengerDTO;
import org.avi1606.ubetprojectauthservices.dto.PassengerSignupDTO;
import org.avi1606.ubetprojectauthservices.models.Passenger;
import org.avi1606.ubetprojectauthservices.services.AuthServices;
import org.avi1606.ubetprojectauthservices.services.JwtServices;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthServices authServices;

    private final AuthenticationManager authenticationManager;

    private final JwtServices jwtServices;

    @Value("${cookie.expiry}")
    private int cookieExpiry;

    @PostMapping("signup/passenger")
    public ResponseEntity<PassengerDTO> signup(@RequestBody PassengerSignupDTO passengerSignupDTO) {
        PassengerDTO response = authServices.signupPassenger(passengerSignupDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("signin/passenger")
    public ResponseEntity<?> signin(@RequestBody AuthRequestDTO authRequestDTO, HttpServletResponse response) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getEmail(), authRequestDTO.getPassword()));
        if (authentication.isAuthenticated()) {
            String jwtToken = jwtServices.createTokenWithEmail(Objects.requireNonNull(authentication.getPrincipal()).toString());
            ResponseCookie responseCookie = ResponseCookie.fromClientResponse("jwtToken", jwtToken)
                    .httpOnly(true)
                    .secure(false)
                    .maxAge(cookieExpiry)
                    .path("/")
                    .build();
            response.setHeader(HttpHeaders.SET_COOKIE,responseCookie.toString());
            return new ResponseEntity<>(jwtToken, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Failed Auth", HttpStatus.OK);
        }
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validateJwtToken(HttpServletRequest request) {
        for (Cookie cookie : request.getCookies()) {
            System.out.println(cookie.getName()+" "+ cookie.getValue());
        }
        return new ResponseEntity<>("success", HttpStatus.OK);

    }

}

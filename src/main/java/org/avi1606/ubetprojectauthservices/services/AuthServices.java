package org.avi1606.ubetprojectauthservices.services;

import lombok.AllArgsConstructor;
import org.avi1606.ubetprojectauthservices.dto.PassengerDTO;
import org.avi1606.ubetprojectauthservices.dto.PassengerSignupDTO;
import org.avi1606.ubetprojectauthservices.models.Passenger;
import org.avi1606.ubetprojectauthservices.repositories.PassengerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor
public class AuthServices {

    private final PassengerRepository passengerRepository;

    public PassengerDTO signupPassenger(@RequestBody PassengerSignupDTO passengerSignupDTO) {
        Passenger passenger = Passenger.builder()
                .name(passengerSignupDTO.getName())
                .email(passengerSignupDTO.getEmail())
                .phonenumber(passengerSignupDTO.getPhonenumber())
                .password(passengerSignupDTO.getPassword()) //Encrypt the password
                .build();

        Passenger passenger1 = passengerRepository.save(passenger);

        return PassengerDTO.toDTO(passenger1);
    }
}

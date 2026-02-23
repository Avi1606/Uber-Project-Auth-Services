package org.avi1606.ubetprojectauthservices.dto;

import lombok.*;
import org.avi1606.ubetprojectauthservices.models.Passenger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassengerDTO {

    String id;

    String name;

    String email;

    String password;

    String phonenumber;

    public static PassengerDTO toDTO(Passenger passenger) {
        return PassengerDTO.builder()
                .id(String.valueOf(passenger.getId()))
                .name(passenger.getName())
                .email(passenger.getEmail())
                .password(passenger.getPassword())
                .phonenumber(passenger.getPhonenumber())
                .build();
    }

}

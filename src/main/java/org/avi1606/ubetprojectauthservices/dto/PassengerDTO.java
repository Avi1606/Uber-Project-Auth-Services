package org.avi1606.ubetprojectauthservices.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDTO {

    private String name;

    private String email;

    private String password;
}

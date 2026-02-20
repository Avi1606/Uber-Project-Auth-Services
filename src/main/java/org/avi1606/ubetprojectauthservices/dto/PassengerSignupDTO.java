package org.avi1606.ubetprojectauthservices.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PassengerSignupDTO {

     String id;

     String name;

     String email;

     String password;

     String phonenumber;
}

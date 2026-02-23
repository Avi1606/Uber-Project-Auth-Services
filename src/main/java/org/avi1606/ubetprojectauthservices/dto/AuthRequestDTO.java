package org.avi1606.ubetprojectauthservices.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthRequestDTO {

    private String email;

    private String password;
}

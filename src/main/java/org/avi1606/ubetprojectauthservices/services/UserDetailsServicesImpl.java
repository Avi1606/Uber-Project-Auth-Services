package org.avi1606.ubetprojectauthservices.services;

import lombok.AllArgsConstructor;
import org.avi1606.uberprojectentity.models.Passenger;
import org.avi1606.ubetprojectauthservices.helper.AuthPassengerSecurity;
import org.avi1606.ubetprojectauthservices.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServicesImpl implements UserDetailsService {

    @Autowired
    private PassengerRepository passengerRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Passenger> passenger = passengerRepository.findPassengerByEmail(email);
        if (passenger.isPresent()) {
            return new AuthPassengerSecurity(passenger.get());
        }else{
            throw new UsernameNotFoundException("Username Not Found");
        }
    }
}

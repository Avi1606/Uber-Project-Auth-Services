package org.avi1606.ubetprojectauthservices.repositories;

import org.avi1606.uberprojectentity.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {

    Optional<Driver> findByAadharCardNumber(String aadharCardNumber) ;
}

package com.login.jdbclogin.Registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RegistrationRepository extends JpaRepository<RegistrationModel,Long> {
}

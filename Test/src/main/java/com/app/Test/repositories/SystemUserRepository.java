package com.app.Test.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Test.models.SystemUser;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, Long> {

	Optional<SystemUser> findByCode(String code);

	Boolean existsByCode(String username);

	Boolean existsByMail(String email);

}

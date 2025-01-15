package com.gomo.Technology_Hub.repository;

import com.gomo.Technology_Hub.enums.AppUserRole;
import com.gomo.Technology_Hub.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Long> {
    Optional<AppUser> findByUserName(String username);

    Optional<AppUser> findFirstByEmail(String email);

    AppUser findByRole(AppUserRole appUserRole);
}

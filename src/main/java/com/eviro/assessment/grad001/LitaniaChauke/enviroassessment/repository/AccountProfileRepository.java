package com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.repository;

import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.entities.AccountProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * The interface Account profile repository.
 */
@Repository
public interface AccountProfileRepository extends JpaRepository<AccountProfile, UUID> {
    /**
     * Find by name and surname account profile.
     *
     * @param name    the name
     * @param surname the surname
     * @return the account profile
     */
    AccountProfile findByNameAndSurname(String name, String surname);
}

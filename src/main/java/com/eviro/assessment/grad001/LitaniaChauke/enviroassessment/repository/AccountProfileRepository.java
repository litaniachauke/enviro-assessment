package com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.repository;

import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.entities.AccountProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.stereotype.Repository;


import java.util.UUID;
@Repository
public interface AccountProfileRepository extends JpaRepository<AccountProfile, UUID> {
    AccountProfile findByNameAndSurname(String name, String surname);
}

package com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.entities;

import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.dto.AccountProfileDTO;
import jakarta.persistence.*;
import lombok.*;

import java.net.URI;
import java.util.UUID;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class AccountProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String name;
    private String surname;
    private URI httpImageLink;

    public AccountProfile(String name, String surname, URI httpImageLink) {
        this.name = name;
        this.surname = surname;
        this.httpImageLink = httpImageLink;
    }


    public AccountProfileDTO toAccountProfileDTO(){
        return new AccountProfileDTO(
                this.uuid,
                this.name,
                this.surname,
                this.httpImageLink
        );
    }
}

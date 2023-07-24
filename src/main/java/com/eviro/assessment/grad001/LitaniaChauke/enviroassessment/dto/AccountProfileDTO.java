package com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.dto;

import java.net.URI;
import java.util.UUID;

public record AccountProfileDTO(
        UUID id,
        String name,
        String surname,
        URI httpImageLink
) {
}

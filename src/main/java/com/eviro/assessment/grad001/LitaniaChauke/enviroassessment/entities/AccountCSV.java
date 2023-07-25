package com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.entities;

import lombok.*;

@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountCSV {
    private String name;
    private String surname;
    private String format;
    private String base64ImageData;

}

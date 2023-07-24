package com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.parser.converter;

import com.eviro.assessment.grad001.LitaniaChauke.enviroassessment.entities.AccountProfile;

import java.net.URI;

public interface AccountProfileConverter {
    public AccountProfile getAccountProfileFromCSV(String line);
}

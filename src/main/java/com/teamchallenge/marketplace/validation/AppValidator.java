package com.teamchallenge.marketplace.validation;

import org.springframework.stereotype.Component;

@Component
public class AppValidator implements Validator {
    @Override
    public void validate(Validation validation) {
        if (!validation.isValid()) {
            throw new RuntimeException(validation.errorMessage());
        }
    }
}

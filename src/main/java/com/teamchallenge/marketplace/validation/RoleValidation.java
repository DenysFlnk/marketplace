package com.teamchallenge.marketplace.validation;

import com.teamchallenge.marketplace.entity.user.UserRole;

import java.util.List;
import java.util.Set;

public class RoleValidation implements Validation {
    private final List<UserRole> allRoles;

    private final Set<UserRole> toValidate;

    private static final String ERROR_MESSAGE = "Inappropriate role name - ";

    private String wrongRoleName;

    public RoleValidation(List<UserRole> allRoles, Set<UserRole> toValidate) {
        this.allRoles = allRoles;
        this.toValidate = toValidate;
    }

    @Override
    public boolean isValid() {
        for (UserRole role : toValidate) {
            boolean match = allRoles.stream().anyMatch(r -> r.getName().equals(role.getName()));
            if (!match) {
                wrongRoleName = role.getName();
                return false;
            }
        }
        return true;
    }

    @Override
    public String errorMessage() {
        if (wrongRoleName == null) {
            return null;
        }

        return ERROR_MESSAGE + wrongRoleName;
    }
}

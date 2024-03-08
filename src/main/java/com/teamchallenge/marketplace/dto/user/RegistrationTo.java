package com.teamchallenge.marketplace.dto.user;

import com.teamchallenge.marketplace.entity.user.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class RegistrationTo {
    @NotBlank
    @Size(min = 3, max = 30)
    private String username;

    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 30)
    private String password;

    @NotNull
    private Set<UserRole> roles;
}

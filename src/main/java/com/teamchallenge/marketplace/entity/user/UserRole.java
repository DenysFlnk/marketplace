package com.teamchallenge.marketplace.entity.user;

import com.teamchallenge.marketplace.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRole extends BaseEntity {
    @Column(name = "name")
    @NotBlank
    private String name;

    public UserRole(UserRole role) {
        this.id = role.getId();
        this.name = role.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserRole userRole = (UserRole) o;
        return Objects.equals(name, userRole.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}

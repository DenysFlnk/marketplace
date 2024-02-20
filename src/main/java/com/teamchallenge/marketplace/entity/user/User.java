package com.teamchallenge.marketplace.entity.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.teamchallenge.marketplace.entity.BaseEntity;
import com.teamchallenge.marketplace.entity.product.Product;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends BaseEntity {
    @Nullable
    @ToString.Exclude
    private String imgUrl;

    @Column(name = "username")
    @NotBlank
    @Size(min = 3, max = 30)
    private String username;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "us_password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ToString.Exclude
    private String password;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "role_id"))
    @ElementCollection(fetch = FetchType.LAZY)
    private Set<Role> roles;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(table = "user_favorites", name = "product_id", nullable = false)
    @ToString.Exclude
    private List<Product> favorites;

    public User(User user) {
        this.id = user.getId();
        this.imgUrl = user.getImgUrl();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.getRoles();
        this.favorites = user.getFavorites();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return username.equals(user.username) && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), username, email);
    }
}

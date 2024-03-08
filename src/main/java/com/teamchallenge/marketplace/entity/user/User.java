package com.teamchallenge.marketplace.entity.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.teamchallenge.marketplace.entity.BaseEntity;
import com.teamchallenge.marketplace.entity.order.Order;
import com.teamchallenge.marketplace.entity.product.Product;
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
    @OneToOne(mappedBy = "user")
    @ToString.Exclude
    private UserImage avatar;

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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @ToString.Exclude
    private Set<UserRole> roles;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_favorites",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    @ToString.Exclude
    private List<Product> favorites;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<Order> orderHistory;

    public User(User user) {
        this.id = user.getId();
        this.avatar = user.getAvatar();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.getRoles();
        this.favorites = user.getFavorites();
        this.orderHistory = user.getOrderHistory();
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

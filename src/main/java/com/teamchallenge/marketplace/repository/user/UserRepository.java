package com.teamchallenge.marketplace.repository.user;

import com.teamchallenge.marketplace.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT us FROM User us LEFT JOIN FETCH us.favorites WHERE us.id = :id")
    Optional<User> getWithFavorites(int id);
}

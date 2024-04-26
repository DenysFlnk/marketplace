package com.teamchallenge.marketplace.repository.user;

import com.teamchallenge.marketplace.entity.user.UserImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserImageRepository extends JpaRepository<UserImage, Integer> {
    @Query(value = "SELECT nextval() FROM user_img", nativeQuery = true)
    int getNextId();
}

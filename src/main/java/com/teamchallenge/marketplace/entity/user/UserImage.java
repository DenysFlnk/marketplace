package com.teamchallenge.marketplace.entity.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.teamchallenge.marketplace.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "user_img")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserImage extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user-image")
    @ToString.Exclude
    private User user;

    @Column(name = "img_url")
    private String imgUrl;

    public UserImage(UserImage image) {
        this.id = image.getId();
        this.user = image.getUser();
        this.imgUrl = image.getImgUrl();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserImage userImage = (UserImage) o;
        return Objects.equals(imgUrl, userImage.imgUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), imgUrl);
    }
}

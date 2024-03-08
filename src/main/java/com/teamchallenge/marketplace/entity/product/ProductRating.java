package com.teamchallenge.marketplace.entity.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.teamchallenge.marketplace.entity.BaseEntity;
import com.teamchallenge.marketplace.entity.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import java.util.Objects;

@Entity
@Table(name = "product_rating")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductRating extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonBackReference(value = "product-rating")
    @ToString.Exclude
    private Product product;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user-rating")
    @ToString.Exclude
    private User user;

    @Column(name = "rating")
    @NotBlank
    @Range(min = 1, max = 5)
    private Integer rating;

    @Column(name = "comment")
    private String comment;

    public ProductRating(ProductRating rating) {
        this.product = rating.getProduct();
        this.user = rating.getUser();
        this.rating = rating.getRating();
        this.comment = rating.getComment();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductRating that = (ProductRating) o;
        return Objects.equals(rating, that.rating) && Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rating, comment);
    }
}

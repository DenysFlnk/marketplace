package com.teamchallenge.marketplace.entity.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.teamchallenge.marketplace.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "product_img")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductImage extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonBackReference
    @ToString.Exclude
    private Product product;

    @Column(name = "img_url")
    private String imgUrl;

    public ProductImage(ProductImage image) {
        this.id = image.getId();
        this.product = image.getProduct();
        this.imgUrl = image.getImgUrl();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductImage that = (ProductImage) o;
        return Objects.equals(imgUrl, that.imgUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), imgUrl);
    }
}

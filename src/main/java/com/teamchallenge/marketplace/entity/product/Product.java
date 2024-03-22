package com.teamchallenge.marketplace.entity.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.teamchallenge.marketplace.entity.BaseEntity;
import com.teamchallenge.marketplace.entity.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product extends BaseEntity {
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    @ToString.Exclude
    private List<ProductImage> images;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    @JsonBackReference(value = "creator-product")
    @ToString.Exclude
    private User creator;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "quantity")
    @NotBlank
    @Range(min = 1)
    private Integer quantity;

    @Column(name = "price")
    @NotBlank
    @Range(min = 1)
    private Integer price;

    @Column(name = "description")
    @NotBlank
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @ToString.Exclude
    private List<ProductCategory> categories;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_rating",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    @ToString.Exclude
    private List<ProductRating> ratings;

    public Product(Product product) {
        this.id = product.getId();
        this.images = product.getImages();
        this.creator = product.getCreator();
        this.name = product.getName();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.categories = product.getCategories();
        this.ratings = product.getRatings();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return Objects.equals(quantity, product.quantity) && Objects.equals(price, product.price) &&
                Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), quantity, price, description);
    }
}

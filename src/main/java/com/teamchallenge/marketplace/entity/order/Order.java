package com.teamchallenge.marketplace.entity.order;

import com.teamchallenge.marketplace.entity.BaseEntity;
import com.teamchallenge.marketplace.entity.product.Product;
import com.teamchallenge.marketplace.entity.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @ToString.Exclude
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;

    @Column(name = "quantity")
    @NotBlank
    @Range(min = 1)
    private Integer quantity;

    @Column(name = "total_price")
    @NotBlank
    @Range(min = 1)
    private Integer totalPrice;

    @Column(name = "order_date")
    @NotBlank
    private LocalDateTime orderDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    @NotBlank
    private OrderStatus status;

    public Order(Order order) {
        this.product = order.getProduct();
        this.user = order.getUser();
        this.quantity = order.getQuantity();
        this.totalPrice = order.getTotalPrice();
        this.orderDate = order.getOrderDate();
        this.status = order.getStatus();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return Objects.equals(quantity, order.quantity) && Objects.equals(totalPrice, order.totalPrice) &&
                Objects.equals(orderDate, order.orderDate) && status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), quantity, totalPrice, orderDate, status);
    }
}

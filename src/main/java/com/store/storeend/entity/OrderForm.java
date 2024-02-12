package com.store.storeend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_form")
public class OrderForm {
    @Id
    @Column(name = "id", length = 10, nullable = false)
    private Integer id;

    @Column(name = "product_id", length = 10, nullable = false)
    private Integer productId;

    @Column(name = "user_id", length = 10, nullable = false)
    private Integer userId;

    @Column(name = "status", length = 10, nullable = false)
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderForm{" +
                "id=" + id +
                ", productId=" + productId +
                ", userId=" + userId +
                ", status=" + status +
                '}';
    }
}

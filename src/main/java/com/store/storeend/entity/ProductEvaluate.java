package com.store.storeend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_evaluate")
public class ProductEvaluate {
    @Id
    @Column(name = "id", length = 10, nullable = false)
    private Integer id;

    @Column(name = "product_id", length = 10, nullable = false)
    private Integer productId;

    @Column(name = "content", nullable = false)
    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ProductEvaluate{" +
                "id=" + id +
                ", productId=" + productId +
                ", content='" + content + '\'' +
                '}';
    }
}

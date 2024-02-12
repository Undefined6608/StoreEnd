package com.store.storeend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_type")
public class ProductType {
    @Id
    @Column(name = "id", length = 10, nullable = false)
    private Integer id;

    @Column(name = "root", length = 10, nullable = false)
    private Integer root;

    @Column(name = "type", nullable = false)
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoot() {
        return root;
    }

    public void setRoot(Integer root) {
        this.root = root;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", root=" + root +
                ", type='" + type + '\'' +
                '}';
    }
}

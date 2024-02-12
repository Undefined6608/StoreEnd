package com.store.storeend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "location_goods")
public class LocationGoods {
    @Id
    @Column(name = "id",length = 10, nullable = false)
    private Integer id;

    @Column(name = "order_id",length = 10, nullable = false)
    private Integer orderId;

    @Column(name = "status",length = 3, nullable = false)
    private Integer status;

    @Column(name = "position")
    private String position;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "LocationGoods{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", status=" + status +
                ", position='" + position + '\'' +
                '}';
    }
}

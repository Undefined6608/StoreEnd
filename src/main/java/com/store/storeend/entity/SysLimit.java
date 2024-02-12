package com.store.storeend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 系统权限
 */
@Entity
@Table(name = "sys_limit")
public class SysLimit {
    @Id
    @Column(name = "id",length = 10,nullable = false)
    private Integer id;

    @Column(name = "type",nullable = false)
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SysLimit{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}

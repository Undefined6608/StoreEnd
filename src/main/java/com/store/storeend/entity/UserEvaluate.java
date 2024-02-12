package com.store.storeend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_evaluate")
public class UserEvaluate {
    @Id
    @Column(name = "id", length = 10, nullable = false)
    private Integer id;

    @Column(name = "user_id", length = 10, nullable = false)
    private Integer userId;

    @Column(name = "content", nullable = false)
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "UserEvaluate{" +
                "id=" + id +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                '}';
    }
}

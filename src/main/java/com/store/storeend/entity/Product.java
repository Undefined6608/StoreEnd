package com.store.storeend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "id", length = 10, nullable = false)
    private Integer id;

    @Column(name = "type_id", length = 10, nullable = false)
    private Integer typeId;

    @Column(name = "icon", nullable = false)
    private String icon;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "recommend", length = 10, nullable = false)
    private Integer recommend;

    @Column(name = "not_recommended", length = 10, nullable = false)
    private Integer notRecommended;

    @Column(name = "collect", length = 10, nullable = false)
    private Integer collect;

    @Column(name = "uid", length = 36, nullable = false)
    private String uid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public Integer getNotRecommended() {
        return notRecommended;
    }

    public void setNotRecommended(Integer notRecommended) {
        this.notRecommended = notRecommended;
    }

    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", icon='" + icon + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", recommend=" + recommend +
                ", notRecommended='" + notRecommended + '\'' +
                ", collect=" + collect +
                ", uid='" + uid + '\'' +
                '}';
    }
}

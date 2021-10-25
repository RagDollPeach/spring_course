package com.example.struct.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime pub_date;
    private Short is_bestseller;
    private String slug;
    private String title;
    private String image;
    private String description;
    private String price;
    private Short discount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getPub_date() {
        return pub_date;
    }

    public void setPub_date(LocalDateTime pub_date) {
        this.pub_date = pub_date;
    }

    public Short getIs_bestseller() {
        return is_bestseller;
    }

    public void setIs_bestseller(Short is_bestseller) {
        this.is_bestseller = is_bestseller;
    }

    public void setDiscount(Short discount) {
        this.discount = discount;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public short getDiscount() {
        return discount;
    }

    public void setDiscount(short discount) {
        this.discount = discount;
    }
}

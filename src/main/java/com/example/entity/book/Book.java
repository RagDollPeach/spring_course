package com.example.entity.book;

import com.example.entity.author.Author;
import org.springframework.web.servlet.tags.form.TextareaTag;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate pub_date;
    private Short is_bestseller;
    private String slug;
    private String title;
    private String image;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String price;
    private Short discount;

    @ManyToMany()
    @JoinTable(
            name = "book2author",
            joinColumns = { @JoinColumn(name = "book_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "author_id", referencedColumnName = "id") }
    )
    private List<Author> authors;

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPub_date() {
        return pub_date;
    }

    public void setPub_date(LocalDate pub_date) {
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

package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    Long id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    double price;
    @Column(nullable = false)
    String codeBarre;
    @Column(nullable = false)
    String detail;

    public Product() {
    }

    public Product(Long id, String name, double price, String codeBarre, String detail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.codeBarre = codeBarre;
        this.detail = detail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}

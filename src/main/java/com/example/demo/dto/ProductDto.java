package com.example.demo.dto;

public class ProductDto {

    Long id;
    String name;
    double price;
    String codeBarre;
    String detail;

    public ProductDto() {
    }

    public ProductDto(Long id, String name, double price, String codeBarre, String detail) {
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


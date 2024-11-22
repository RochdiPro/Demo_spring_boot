package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue
    private Long id ;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(nullable = false)
    private double total ;

    @Column(nullable = false)
    Date createdDate;



    @ManyToMany
    @JoinTable(name = "invoices_products_ta", foreignKey = @ForeignKey(name = "inv_id"), inverseForeignKey = @ForeignKey(name = "prod_id"))
    private List<Product> invoiceProducts;
}

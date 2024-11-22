package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "voucher")
public class Voucher {
    @Id
    @GeneratedValue
    private Long id ;
    @Column(unique = true, nullable = false)
    private String type ;

    @Column(nullable = false)
    private double total;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToMany()
    @JoinTable(name = "voucher_products_ta", foreignKey = @ForeignKey(name = "vou_id"), inverseForeignKey = @ForeignKey(name = "prod_id_vou"))
    private List<Product> voucherProducts;
}

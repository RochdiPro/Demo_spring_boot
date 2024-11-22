package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue
    private Long id ;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String LastName ;
    @Column(nullable = false)
    private double accountBalance ;
}

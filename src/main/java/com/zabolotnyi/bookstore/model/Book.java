package com.zabolotnyi.bookstore.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "BOOKS")
@Data

public class Book {
    @Id
    @Column(name = "ID",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE",length = 32,nullable = false)
    private String title;

    @ManyToOne()
    @Column(name = "AUTHOR",nullable = false)
    private Author author;

    @Column(name = "YEAR",length = 4)
    private String issueYear;

    @Column(name = "PRICE",nullable = false,scale = 2)
    private BigDecimal price;
}

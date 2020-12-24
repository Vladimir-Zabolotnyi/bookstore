package com.zabolotnyi.bookstore.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "BOOKS")
@Data

public class Book {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE",length = 32)
    private String title;

    @ManyToOne
    private Author author;

    @Column(name = "YEAR",length = 4)
    private String issueYear;

    @Column(name = "PRICE")
    private BigDecimal price;
}

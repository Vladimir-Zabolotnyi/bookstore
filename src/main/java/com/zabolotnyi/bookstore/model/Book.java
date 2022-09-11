package com.zabolotnyi.bookstore.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

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
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @Column(name = "YEAR",length = 4)
    private String issueYear;

    @Column(name = "PRICE",nullable = false,scale = 2)
    private BigDecimal price;
}

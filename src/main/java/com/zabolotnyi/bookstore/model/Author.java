package com.zabolotnyi.bookstore.model;

import lombok.Data;


import javax.persistence.*;

@Entity
@Data

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 32)
    private String name;

    @Column(length = 32)
    private String surname;


}

package com.zabolotnyi.bookstore.model;

import lombok.Data;


import javax.persistence.*;

@Entity
@Data
@Table(name = "AUTHORS")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "AUTHOR_NAME",length = 32,nullable = false)
    private String name;

    @Column(name = "AUTHOR_SURNAME",length = 32,nullable = false)
    private String surname;


}

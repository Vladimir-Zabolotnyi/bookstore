package com.zabolotnyi.bookstore.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "CLIENTS")
public class Client {

    @Id
    @Column(name = "ID",length = 32,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME",length = 32,nullable = false)
    private String name;

    @Column(name = "SURNAME",length = 32,nullable = false)
    private String surname;

    @Column(name = "EMAIL",length = 32,nullable = false)
    private String email;

    @Column(name = "BIRTHDAY",length = 32,nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date dateOfBirth;
}

package com.zabolotnyi.bookstore.model;

import lombok.Data;


import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Data
@Table(name = "ORDERS")
public class Order {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "client_name")),
            @AttributeOverride(name = "surname", column = @Column(name = "client_surname")),
            @AttributeOverride(name = "email", column = @Column(name = "client_email"))
    })
    private AddressOfDelivery addressOfDelivery;

//    Как это сделать
//    private List<Book> listOfBookBoughtByClient;

    private BigDecimal valueOfTheOrder;
}

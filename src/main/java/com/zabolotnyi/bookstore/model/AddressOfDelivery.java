package com.zabolotnyi.bookstore.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class AddressOfDelivery {
    @Column(name = "COUNTRY" ,length = 32,nullable = false)
    private String country;
    @Column(name = "CITY",length = 32,nullable = false)
    private String city;
    @Column(name = "STREET",length = 32,nullable = false)
    private String street;
    @Column(name = "BUILDING",length = 32,nullable = false)
    private String building;
}

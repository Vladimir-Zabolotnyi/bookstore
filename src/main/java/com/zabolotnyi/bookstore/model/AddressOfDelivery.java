package com.zabolotnyi.bookstore.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class AddressOfDelivery {
    private String country;
    private String city;
    private String street;
    private String building;
}

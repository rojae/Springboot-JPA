package org.rojae.examples;

import lombok.Builder;

import javax.persistence.Embeddable;

@Embeddable
@Builder
public class Address {

    private String street;

    private String city;

    private String state;

    private String zipCode;

}

package com.sda.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "adresy")
public class Adress {

    @Id
    @Column(name = "id_adresu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ulica")
    private String street;
    @Column(name = "numer_domu")
    private String houseNumber;
    @Column(name = "numer_mieszkania")
    private String flatNumber;
    @Column(name = "kod_pocztowy")
    private String postalCode;
    @Column(name = "miasto")
    private String city;
    @Column(name = "panstwo")
    private String country;
    @Column(name = "wojewodztwo")
    private String province;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}

package com.sda.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "firmy")
public class Firm {

    @Id
    @Column(name = "id_firmy")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nazwa")
    private String name;
    @Column(name = "ulica")
    private String street;
    @Column(name = "numer_domu")
    private String houseNumber;
    @Column(name = "numer_mieszkania")
    private String flatNumber;
    @Column(name = "nip")
    private String nip;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
}

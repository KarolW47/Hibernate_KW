package com.sda.hibernate.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pracownicy")
public class Employee {

    @Id
    @Column(name = "id_pracownika")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "imie")
    private String name;
    @Column(name = "nazwisko")
    private String surname;
    @Column(name = "kolor_oczu")
    private String eyeColor;
    @Column(name = "wzrost")
    private int height;
    @Column(name = "plec")
    private char sex;
    @Column (name = "telefon")
    private String phoneNumber;
    @Column (name = "email")
    private String email;
    @Column(name = "PESEL")
    private String pesel;
    @Column (name = "data_urodzin")
    private Date birthDate;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Job job;
    @Column(name = "wynagrodzenie")
    private int salary;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Firm firm;
    @Column(name = "login")
    private String login;
    @Column(name = "haslo")
    private String haslo;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Firm getFirm() {
        return firm;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
}

package br.com.oppus.api.model.entities;

import javax.persistence.*;

@Entity
@Table
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column()
    private Integer CEP;

    @Column()
    private String UF;

    @Column()
    private String city;

    @Column()
    private String district;

    @Column()
    private String street;

    public Address(){
    }

    public Address(Integer CEP, String UF, String city, String district, String street){
        this.CEP = CEP;
        this.UF = UF;
        this.city = city;
        this.district = district;
        this.street = street;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCEP() {
        return CEP;
    }

    public String getUF() {
        return UF;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getStreet() {
        return street;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCEP(Integer CEP) {
        this.CEP = CEP;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
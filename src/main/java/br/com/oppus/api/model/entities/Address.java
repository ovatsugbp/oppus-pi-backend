package br.com.oppus.api.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "endereços")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column()
    private String CEP;

    @Column()
    private String UF;

    @Column()
    private String city;

    @Column()
    private String district;

    @Column()
    private String street;

    @ManyToOne
    @JoinColumn(name = "schedule_id", referencedColumnName = "id")
    private Schedule schedule;

    public Address(){
    }

    public Address(String CEP, String UF, String city, String district, String street){
        this.CEP = CEP;
        this.UF = UF;
        this.city = city;
        this.district = district;
        this.street = street;

    }

    public Integer getId() {
        return id;
    }

    public String getCEP() {
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

    public void setCEP(String CEP) {
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

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.setSchedule(schedule);
    }
}
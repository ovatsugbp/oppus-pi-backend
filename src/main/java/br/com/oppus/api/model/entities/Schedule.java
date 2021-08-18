package br.com.oppus.api.model.entities;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "agendas")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String availableDay;

    @Column
    private Date startHour;

    @Column
    private Date finishHour;

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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Professional professional;



    public Schedule(){
    }

    public Schedule(String availableDay, Date startHour,
                    Date finishHour, String CEP,
                    String UF, String city,
                    String district, String street) {
        this.availableDay = availableDay;
        this.startHour = startHour;
        this.finishHour = finishHour;
        this.CEP = CEP;
        this.UF = UF;
        this.city = city;
        this.district = district;
        this.street = street;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvailableDay() {
        return availableDay;
    }

    public void setAvailableDay(String availableDay) {
        this.availableDay = availableDay;
    }

    public Date getStartHour() {
        return startHour;
    }

    public void setStartHour(Date startHour) {
        this.startHour = startHour;
    }

    public Date getFinishHour() {
        return finishHour;
    }

    public void setFinishHour(Date finishHour) {
        this.finishHour = finishHour;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }
}
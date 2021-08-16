package br.com.oppus.api.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @JsonIgnore
    @OneToMany(mappedBy = "schedule")
    private List<Address> addresses;


    public Schedule(){
    }

    public Schedule(String availableDay, Date startHour, Date finishHour, List<Address> addresses, Professional professional) {
        this.availableDay = availableDay;
        this.startHour = startHour;
        this.finishHour = finishHour;
        this.setAddresses(addresses);
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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

}
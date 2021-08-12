package br.com.oppus.api.model.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String availableDay;

    @Column
    private Date startHour;

    @Column
    private Date finishHour;

    @ManyToOne(fetch =FetchType.EAGER)
    Professional professional;

    public Schedule(){
    }

    public Schedule(int id, String availableDay) {
        this.id = id;
        this.availableDay = availableDay;
    }

    @Override
    public String toString() {
        return availableDay;
    }

    public String getAvailableDay() {
        return availableDay;
    }
}
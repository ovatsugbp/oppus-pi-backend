package br.com.oppus.api.model.entities;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "profissionais")
public class Professional extends User{
    @Column
    private final boolean isProfessional = true;

    @Column
    private String phone;

    @Column
    private String bio;

    @Column
    private double score;

    @Column
    private String socialMedia;

    @Column
    private double priceActivity;

    @Column
    private String nameActivity;

    @OneToMany
    public List<Schedule> professionalSchedule;

    public Professional() {

    }

    public Professional(String name, String password,
                        String email, String photoURL,
                        String phone, String bio,
                        double score, String socialMedia,
                        double priceActivity, String nameActivity
                        ) {
        super(name, password, email, photoURL);
        this.phone = phone;
        this.bio = bio;
        this.score = score;
        this.socialMedia = socialMedia;
        this.priceActivity = priceActivity;
        this.nameActivity = nameActivity;
    }

    @Override
    public boolean isProfessional() {
        return isProfessional;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(String socialMedia) {
        this.socialMedia = socialMedia;
    }

    public double getPriceActivity() {
        return priceActivity;
    }

    public void setPriceActivity(double priceActivity) {
        this.priceActivity = priceActivity;
    }

    public String getNameActivity() {
        return nameActivity;
    }

    public void setNameActivity(String nameActivity) {
        this.nameActivity = nameActivity;
    }

    public List<Schedule> getProfessionalSchedule() {
        return professionalSchedule;
    }

    public void setProfessionalSchedule(List<Schedule> professionalSchedule) {
        this.professionalSchedule = professionalSchedule;
    }
}


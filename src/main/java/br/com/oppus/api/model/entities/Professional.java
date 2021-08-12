package br.com.oppus.api.model.entities;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import javax.persistence.*;
import java.util.List;


@Entity
@Table
public class Professional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String photoURL;

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

    public Professional(int id, String name, String nameActivity, String email,
                        String photoURL, String phone, Schedule[] schedule) {
        this.id = id;
        this.name = name;
        this.nameActivity = nameActivity;
        this.email = email;
        this.phone = phone;
        this.photoURL = photoURL;

        for (Schedule s: schedule){
            professionalSchedule.add(s);
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

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


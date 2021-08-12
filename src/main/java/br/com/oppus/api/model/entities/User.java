package br.com.oppus.api.model.entities;

import javax.persistence.*;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String photoURL;

    @Column(nullable = false)
    private final boolean isProfessional = false;

    public User(int id, String name, String password, String email, String photoURL) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.photoURL = photoURL;
    }

    @OneToOne
    User user;

    public User() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public boolean isProfessional() {
        return isProfessional;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }
}
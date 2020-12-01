package at.htl.karate.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User extends PanacheEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long Id;

    public String lastname = "";

    public String firstname = "";


    public User() {
    }

    public User(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public Long getId() {
        return Id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

}


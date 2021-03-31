package models;


import java.util.*;
import javax.persistence.*;
import javax.validation.Constraint;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class User extends Model {


    @Id
    private Long id;

    @Constraints.Required
    private String name;

    @Constraints.Required
    private String email;

    private int password;


    public User() {


    }

    public User(Long id, String name, String email, int password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }




    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(int password) {
        this.password = password;
    }




}

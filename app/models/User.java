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
    @Constraints.Required
    private String password;



    public User() {


    }

    public User(String name, String email, String password, Long id) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

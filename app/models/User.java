package models;

import java.util.*;
import javax.persistence.*;
import javax.validation.Constraint;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import services.UserInt;


@Entity
public class User extends Model {

    @Id
    private Long id;
    @Constraints.Required
    private String username;
    @Constraints.Required
    private String email;
    @Constraints.Required
    private String password;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public User() {


    }

    public User(String username, String email, String password, Long id) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.id = id;
    }


}

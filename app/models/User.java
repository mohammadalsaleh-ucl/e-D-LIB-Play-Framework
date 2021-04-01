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
    private String username;
    @Constraints.Required
    private String email;
    @Constraints.Required
    private String password;



    public User() {


    }

    public User(String username, String email, String password, Long id) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.id = id;
    }


}

package dao;

import io.ebean.DB;
import io.ebean.Finder;
import io.ebean.annotation.Transactional;
import models.User;
import org.mindrot.jbcrypt.BCrypt;

public class UserDAO implements UserServices {



    @Transactional
    public boolean findUser(String email, String password) {
        boolean userFound = false;
        User user = DB.find(User.class)
                .where()
                .eq("EMAIL", email)
             //   .and().eq("PASSWORD", password)
                .findOne();

        System.out.println(user.getPassword());
        System.out.println(password);

        if (BCrypt.checkpw(password, user.getPassword()))
            userFound=true;
        else
            userFound=false;

        return userFound;
    }

    public static Finder<Long,User> find = new Finder<>(User.class);

    @Transactional
    public boolean saveUser(User user) {

        System.out.println("In Check save");
        boolean userSave = false;
        DB.save(user);
        if (user != null){
            userSave = true;
        }
        System.out.println(userSave);
        return userSave;
    }

}

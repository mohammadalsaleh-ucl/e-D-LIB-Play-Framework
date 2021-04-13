package dao;

import io.ebean.DB;
import io.ebean.Finder;
import io.ebean.annotation.Transactional;
import models.User;

public class UserDAO implements UserServices {



    @Transactional
    public boolean findUser(String email, String password) {
        boolean userFound = false;
        User user = DB.find(User.class)
                .where()
                .eq("EMAIL", email)
                .and().eq("PASSWORD", password)
                .findOne();
        if (user != null){
            userFound = true;
        }
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

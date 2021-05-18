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

        if (user!=null)
            if (BCrypt.checkpw(password, user.getPassword()))
                userFound=true;
             else
                userFound=false;
        else
             userFound=false;

        return userFound;
    }

    public static Finder<Long,User> find = new Finder<>(User.class);

    @Transactional
    public boolean saveUser(User user) {

        boolean userSave = false;
        DB.save(user);
        if (user != null){
            userSave = true;
        }
        return userSave;
    }

    @Transactional
    public boolean updateUser(User user) {

        System.out.println("In Check update");
        boolean userUpdate = false;


        System.out.println(user.getId());
        String dml = "update user set username=:username,email=:email,password=:password where id = :id";

        int rows = DB.sqlUpdate(dml)
                .setParameter("username", user.getUsername())
                .setParameter("email", user.getEmail())
                .setParameter("password", user.getPassword())
                .setParameter("id", user.getId())
                .execute();

        if (user != null){
            userUpdate = true;
        }
        return userUpdate;
    }


    @Transactional
    public boolean checkAdmin(String actor) {
        if (actor.equals("Admin"))
            return true;
        return false;
    }

    @Transactional
    public boolean checkUser(String actor) {
        if (actor.equals("User"))
            return true;
        return false;
    }


    @Transactional
    public String getActor(String email){
        User user = DB.find(User.class)
                .where()
                .eq("EMAIL", email)
                //   .and().eq("PASSWORD", password)
                .findOne();
        return user.getActor();
    }

}

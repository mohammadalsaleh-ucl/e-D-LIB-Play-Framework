package dao;

import io.ebean.DB;
import io.ebean.Query;
import io.ebean.SqlRow;
import io.ebean.annotation.Transactional;
import models.User;

import java.util.List;

public class UserDAO {


    @Transactional
    public boolean findUser(String username, String password) {
        System.out.println("In Check login");
        boolean userFound = false;

        User user = DB.find(User.class)
                .where()
                .eq("EMAIL", username)
                .and().eq("PASSWORD", password)
                .findOne();
        /*qlRow row =
                DB.sqlQuery(query)
                        .setParameter(0, username)
                        .setParameter(1, password)
                        .findOne();
        System.out.println(row.get("name"));*/

        if (user != null){
            userFound = true;
        }
        System.out.println(userFound);

        return userFound;
    }
}

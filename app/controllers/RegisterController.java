package controllers;

import com.google.inject.Guice;
import models.User;
import dao.UserDAO;
import module.CoreModule;

import com.google.inject.Injector;
import play.mvc.*;

import services.UserInt;
import views.html.admin.*;
import play.db.ebean.Transactional;



public class RegisterController extends Controller {






    public Result register() { return ok(register.render()); }


    @Transactional
     public Result registerUser(String username,String email, String password){

         User user= new User();
         user.setUsername(username);
         user.setEmail(email);
         user.setPassword(password);


        Injector injector= Guice.createInjector(new CoreModule());
        UserInt s=injector.getInstance(UserInt.class);
        // UserDAO userDAO = new UserDAO();
         /* User ser=injector.getInstance(User.class);

        ser.setUsername(username);
        ser.setEmail(email);
        ser.setPassword(password);*/
         boolean isValid = s.saveUser(user);


         return ok(register.render());
     }

}

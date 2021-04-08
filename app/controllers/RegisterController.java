package controllers;

import models.User;
import dao.UserDAO;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import views.html.*;
import views.html.login.*;
import views.html.admin.*;
import play.db.ebean.Transactional;
import java.util.List;
import java.util.ArrayList;
import javax.inject.Inject;
import views.html.admin.*;


public class RegisterController extends Controller {




    public Result register() { return ok(register.render()); }


    @Transactional
     public Result registerUser(String username,String email, String password){

         User user= new User();
         user.setUsername(username);
         user.setEmail(email);
         user.setPassword(password);
         UserDAO userDAO = new UserDAO();

         boolean isValid = userDAO.saveUser(user);


         return ok(register.render());
     }

}

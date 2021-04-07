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



     @Transactional
     public Result registerUser(){


         return ok(register.render(addUserForm));
     }

}

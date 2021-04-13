package controllers;

import com.google.inject.Guice;
import com.google.inject.Inject;
import models.User;
import dao.UserDAO;
import module.CoreModule;

import com.google.inject.Injector;
import play.data.Form;
import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.mvc.*;

import services.UserInt;
import views.html.admin.*;
import play.db.ebean.Transactional;



public class RegisterController extends Controller {


    private final Form<User> form;
    private MessagesApi messagesApi;
    @Inject
    FormFactory formFactory;
    private UserDAO userDAO;
    private User user;



    @Inject
    public RegisterController(FormFactory formFactory, MessagesApi messagesApi) {
        this.form = formFactory.form(User.class);
        this.messagesApi = messagesApi;
        this.userDAO = userDAO;


    }

    public Result register(Http.Request request) { return ok(register.render(form, request, messagesApi.preferred(request))); }

    // create a Form<user>object and get teh user model object from it.

     @Transactional
     public Result registerUser(Http.Request request){

         System.out.println("hello ahmad");

        final Form<User> boundForm = form.bindFromRequest(request);
         System.out.println("hello baage");


         User data = boundForm.get();;
         System.out.println(data.getEmail());
         UserDAO userDAO4 = new UserDAO();
         boolean isValid = userDAO4.saveUser(data);


         System.out.println("hello soda");



         return ok(register.render(form, request, messagesApi.preferred(request)));
     }

}

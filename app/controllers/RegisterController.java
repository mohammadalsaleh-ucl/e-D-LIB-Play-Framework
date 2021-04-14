package controllers;

import com.google.inject.Inject;
import models.User;
import dao.UserDAO;

import play.data.Form;
import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.mvc.*;

import views.html.admin.*;
import play.db.ebean.Transactional;
import dao.Hashhelper;



public class RegisterController extends Controller {


    private final Form<User> form;
    private MessagesApi messagesApi;
    @Inject
    FormFactory formFactory;
    private UserDAO userDAO;
    private User user;
    private Hashhelper hashhelper;

    @Inject
    public RegisterController(FormFactory formFactory, MessagesApi messagesApi) {
        this.form = formFactory.form(User.class);
        this.messagesApi = messagesApi;
        this.userDAO = userDAO;
    }

    public Result viewRegister(Http.Request request) {
        return ok(register.render(form, request, messagesApi.preferred(request)));
    }


     @Transactional
     public Result userRegister(Http.Request request){
         final Form<User> boundForm = form.bindFromRequest(request);
         User data = boundForm.get();

         //System.out.println(data.getPassword());

        // String firstpass=hashhelper.createPassword(data.getPassword());
       //  System.out.println(firstpass);

         data.setPassword(hashhelper.createPassword(data.getPassword()));
       //  System.out.println(data.getPassword());

         /*   String hi= hashhelper.createPassword(password);
        if (BCrypt.checkpw("1212", hi))
            System.out.println("It matches user");
        else
            System.out.println("It does not match user");

        String firstpass=hashhelper.createPassword(password);

        System.out.println(firstpass);

        */

         UserDAO userDAO4 = new UserDAO();
         boolean isValid = userDAO4.saveUser(data);
         return ok(register.render(form, request, messagesApi.preferred(request)));
     }

}

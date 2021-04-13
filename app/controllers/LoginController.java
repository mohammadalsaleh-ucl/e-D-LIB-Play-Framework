package controllers;


import com.google.inject.Inject;
import models.User;
import dao.UserDAO;
import play.data.Form;
import play.data.FormFactory;
import play.data.DynamicForm;
import play.mvc.*;
import views.html.*;
import views.html.login.*;
import views.html.admin.*;
import play.db.ebean.Transactional;
import java.util.List;
import java.util.ArrayList;
import play.i18n.MessagesApi;
import play.mvc.*;

import javax.inject.Singleton;
import java.util.List;



/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */

@Singleton
public class LoginController extends Controller {


    private final Form<User> form;
    private MessagesApi messagesApi;
    @Inject
    FormFactory formFactory;


    @Inject
    public LoginController(FormFactory formFactory, MessagesApi messagesApi) {
        this.form = formFactory.form(User.class);
        this.messagesApi = messagesApi;

    }

    public Result main(Http.Request request) {

        return ok(login.render(form, request, messagesApi.preferred(request)));

    }


    public Result validateLoginGet(Http.Request request) {


        final Form<User> boundForm = form.bindFromRequest(request);

        List<User> usersList=UserDAO.find.all();
      //  Form<User> userForm = formFactory.form(User.class);

         User data = boundForm.get();
        //System.out.println(data.getEmail());

       // User user = userForm.bind(anyData).get();
       // User user = userForm.bindFromRequest().get();

         UserDAO userDAO = new UserDAO();
        String msg = "";
         boolean isValid = userDAO.findUser(data.getEmail(), data.getPassword());
      if(isValid) {
            msg = "Welcome " + data.getEmail() + "!";
        } else {
            //
            msg = "Invalid credentials";
        }


      System.out.println(msg);

        return ok(users.render(usersList));

    }

    public Result users() {

        List<User> usersList=UserDAO.find.all();
        return ok(users.render(usersList));
    }



}

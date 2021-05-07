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

    public Result viewLogin(Http.Request request) {
        return ok(login.render(form, request, messagesApi.preferred(request)));
    }

    @Transactional
    public Result userLogin(Http.Request request) {
        final Form<User> boundForm = form.bindFromRequest(request);

        List<User> usersList=UserDAO.find.all();
            if (boundForm.hasErrors()) {
                return badRequest(login.render(form, request, messagesApi.preferred(request)));
            }
         User data = boundForm.get();
         UserDAO userDAO = new UserDAO();
         String msg = "";
         boolean isValid = userDAO.findUser(data.getEmail(), data.getPassword());

        String act=userDAO.getActor(data.getEmail());

        if(isValid && userDAO.checkAdmin(act) ) {
            return redirect(routes.UsersController.users());
         }
        if(isValid && userDAO.checkUser(act) ) {
            return redirect(routes.MainpageController.viewProjects());
        }

        //flash();
        return redirect(routes.LoginController.viewLogin());
    }

}

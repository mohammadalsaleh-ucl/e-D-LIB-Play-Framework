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
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Controller;


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
        if (boundForm.hasErrors()) {
            return badRequest(login.render(form, request, messagesApi.preferred(request)));
        }
        User data = boundForm.get();
        UserDAO userDAO = new UserDAO();

        boolean isValid = userDAO.findUser(data.getEmail(), data.getPassword());

        if (isValid){
            String act=userDAO.getActor(data.getEmail());
             if(isValid && userDAO.checkAdmin(act) ) {
                 return redirect(routes.UsersController.users());
             }
             if(isValid && userDAO.checkUser(act) ) {
                 return redirect(routes.MainpageController.viewProjects());
             }
         }

        return redirect(routes.LoginController.viewLogin());
    }

}

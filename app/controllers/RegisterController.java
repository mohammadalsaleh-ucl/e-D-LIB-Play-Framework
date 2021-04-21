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
         data.setPassword(hashhelper.createPassword(data.getPassword()));
         UserDAO userDAO4 = new UserDAO();
         boolean isValid = userDAO4.saveUser(data);
         return ok(register.render(form, request, messagesApi.preferred(request)));
     }


    @Transactional
    public Result userUpdate(Http.Request request){
        final Form<User> boundForm = form.bindFromRequest(request);
        User data = boundForm.get();
        data.setPassword(hashhelper.createPassword(data.getPassword()));
        UserDAO userDAO = new UserDAO();
        boolean isValid = userDAO.updateUser(data);
        return ok(register.render(form, request, messagesApi.preferred(request)));
    }
}

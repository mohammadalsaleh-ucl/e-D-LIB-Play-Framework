package controllers;

import com.google.inject.Inject;
import dao.UserDAO;
import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.db.ebean.Transactional;
import play.i18n.MessagesApi;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import views.html.admin.register;
import views.html.admin.*;


public class ProjectController extends Controller {



    private final Form<User> form;
    private MessagesApi messagesApi;
    @Inject
    FormFactory formFactory;
    private UserDAO userDAO;
    private User user;

    @Inject
    public ProjectController(FormFactory formFactory, MessagesApi messagesApi) {
        this.form = formFactory.form(User.class);
        this.messagesApi = messagesApi;
        this.userDAO = userDAO;
    }

    public Result projects(Http.Request request) {
        return ok(project.render(form, request, messagesApi.preferred(request)));
    }

    @Transactional
    public Result addProject(Http.Request request){

        return ok();
    }
}

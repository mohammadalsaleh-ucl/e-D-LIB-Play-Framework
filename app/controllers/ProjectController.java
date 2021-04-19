package controllers;

import com.google.inject.Inject;
import dao.ProjectDAO;
import dao.UserDAO;
import models.Project;
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


    private final Form<Project> form;
    private MessagesApi messagesApi;
    @Inject
    FormFactory formFactory;
    private UserDAO userDAO;
    private User user;

    @Inject
    public ProjectController(FormFactory formFactory, MessagesApi messagesApi) {
        this.form = formFactory.form(Project.class);
        this.messagesApi = messagesApi;
        this.userDAO = userDAO;
    }

    public Result viewProject(Http.Request request) {
        return ok(project.render(form, request, messagesApi.preferred(request)));
    }

    @Transactional
    public Result projectRegister(Http.Request request){
        final Form<Project> boundForm = form.bindFromRequest(request);
        Project data = boundForm.get();
        ProjectDAO projectDAO = new ProjectDAO();
        boolean isValid = projectDAO.saveProject(data);
        return ok(project.render(form, request, messagesApi.preferred(request)));
    }
}

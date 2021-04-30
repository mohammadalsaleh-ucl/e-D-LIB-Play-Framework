package controllers;

import dao.ProjectDAO;
import dao.UserDAO;
import io.ebean.annotation.Transactional;
import models.Project;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.admin.projectslist;

import java.util.List;

public class ProjectsListController extends Controller {



    public Result projects() {
        List<Project> projectList= ProjectDAO.find.all();
        return ok(projectslist.render(projectList));
    }


    @Transactional
    public Result deleteProject(Long id) {
        ProjectDAO.find.ref(id).delete();
        return redirect(routes.ProjectsListController.projects());
    }
}

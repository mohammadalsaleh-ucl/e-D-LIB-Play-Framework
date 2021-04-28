package controllers;

import dao.ProjectDAO;
import models.Project;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.user.main;

import java.util.List;

public class MainpageController extends Controller {


    public Result viewProjects() {

        List<Project> projectsList= ProjectDAO.find.all();
        return ok(main.render(projectsList));
    }


}

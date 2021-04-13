package controllers;

import dao.UserDAO;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.admin.users;

import java.util.List;

public class UsersController extends Controller {

    public Result users() {
        List<User> usersList= UserDAO.find.all();
        return ok(users.render(usersList));
    }

}

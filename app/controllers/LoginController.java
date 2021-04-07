package controllers;


import models.User;
import dao.UserDAO;
import play.mvc.*;
import views.html.*;
import views.html.login.*;
import views.html.admin.*;
import play.db.ebean.Transactional;
import java.util.List;
import java.util.ArrayList;




/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class LoginController extends Controller {


    public Result main() { return ok(login.render()); }


    public Result validateLoginGet(String email , String password) {

        UserDAO userDAO = new UserDAO();
        String msg = "";
        boolean isValid = userDAO.findUser(email, password);
        if(isValid) {
            msg = "Welcome " + email + "!";
        } else {
            //
            msg = "Invalid credentials";
        }

        return ok(dashboard.render());

    }

    public Result users() {

        List<User> usersList=UserDAO.find.all();
        return ok(users.render(usersList));
    }



}

package controllers;


import models.User;
import dao.UserDAO;
import play.mvc.*;
import views.html.login.main;
import views.html.admin.adminmain;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class LoginController extends Controller {


    public Result main() { return ok(main.render()); }


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

        return ok("Hello " + email + " " + password + msg);

    }



}

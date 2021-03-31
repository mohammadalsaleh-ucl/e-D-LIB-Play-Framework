package controllers;

import play.mvc.*;
import views.html.login.main;
import views.html.admin.adminmain;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class LoginController extends Controller {

    /**
     *
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */

    //FormFactory formFactory;

    public Result main() { return ok(main.render()); }


    public Result validateLoginGet(String email , String password) {
       // DynamicForm requestData = formFactory.form().bindFromRequest(request);
       // String email = requestData.get(email);
       // String password = requestData.get("password");
        return ok("Hello " + email + " " + password);

    }



}

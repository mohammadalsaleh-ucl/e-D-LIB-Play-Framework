package controllers;

import com.google.inject.Inject;
import dao.UserDAO;
import io.ebean.annotation.Transactional;
import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import views.html.admin.*;

import java.util.List;

public class UsersController extends Controller {

    private final Form<User> form;
    private MessagesApi messagesApi;
    @Inject
    FormFactory formFactory;


    @Inject
    public UsersController(FormFactory formFactory, MessagesApi messagesApi) {
        this.form = formFactory.form(User.class);
        this.messagesApi = messagesApi;

    }
    public Result users() {
        List<User> usersList= UserDAO.find.all();
        return ok(users.render(usersList));
    }


    @Transactional
    public Result deleteUser(Long id) {
        UserDAO.find.ref(id).delete();
        return redirect(routes.UsersController.users());
    }

    @Transactional
    public Result updateUser(Long id, Http.Request request) {

        User editUser = UserDAO.find.byId(id);
        System.out.println(editUser.getEmail());
        System.out.println(editUser.getId());

        if (editUser == null){
            return badRequest("error");
        }
        Form<User> updateUserForm = formFactory.form(User.class).fill(editUser);
        return ok(register.render(updateUserForm,request, messagesApi.preferred(request)));
    }

}

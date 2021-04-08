package module;

import com.google.inject.AbstractModule;
import dao.UserDAO;
import models.User;
import services.UserInt;

public class CoreModule extends AbstractModule {

    @Override
    protected void configure() {
        // object factories
        bind(UserInt.class).to(UserDAO.class);
        //bind(User.class).to(User.class);
    }
}


package module;

import com.google.inject.AbstractModule;
import dao.UserDAO;
import dao.UserServices;

public class CoreModule extends AbstractModule {

    @Override
    protected void configure() {
        // object factories
        bind(UserServices.class).to(UserDAO.class);
        //bind(User.class).to(User.class);
    }
}


package services;
import models.User;

public interface UserInt {

    public boolean findUser(String email, String password);
    public boolean saveUser(models.User user);


}

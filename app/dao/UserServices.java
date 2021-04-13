package dao;
import models.User;

public interface UserServices {
    public boolean findUser(String email, String password);
    public boolean saveUser(models.User user);
}

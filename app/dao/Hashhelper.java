package dao;

import org.mindrot.jbcrypt.BCrypt;
import play.mvc.Controller;

public class Hashhelper extends Controller {

    public static String createPassword(String clearString) {
        if (clearString == null) {
             System.out.println("error");
        }
        return BCrypt.hashpw(clearString, BCrypt.gensalt());
    }

}

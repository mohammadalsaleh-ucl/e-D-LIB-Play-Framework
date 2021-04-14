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


   /* public static boolean checkPassword(String candidate, String encryptedPassword) {
        if (candidate == null) {
            return false;
        }
        if (encryptedPassword == null) {
            return false;
        }
        return BCrypt.checkpw(candidate, encryptedPassword);
    }*/

}

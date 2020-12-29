package Controller;


public class RegisterController extends AbstractController {
    public RegisterController(){

    }

    public Boolean RegisterNewUser(String _name, int _hash){
        if (!_name.isBlank()) {
            userDB.addEntry(_name, _hash);
            current_user = userDB.getUserEntry(userDB.getLengthOfDatabase() - 1).getUserId();
            return true;
        }
        return false;
    }
}

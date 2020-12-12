package Controller;


public class RegisterController extends AbstractController {
    public RegisterController(){

    }

    public Boolean RegisterNewUser(String _name){
        if (!_name.isBlank()) {
            userDB.addEntry(_name);
            return true;
        }
        return false;
    }
}

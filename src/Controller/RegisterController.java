package Controller;


public class RegisterController extends AbstractController {
    public RegisterController(){

    }

    public Boolean RegisterNewUser(String _name, int _hash){
        if (!_name.isBlank()) {
            userDB.addEntry(_name, _hash);
            return true;
        }
        return false;
    }
}

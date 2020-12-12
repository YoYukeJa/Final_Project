package Controller;

public class LoginController extends AbstractController{


    public LoginController(){

    }

    public Boolean checkIfLoginIsCorrect(String _username, String _password){
        for (int i = 0; i < userDB.getLengthOfDatabase(); i++) {
            if (userDB.getUserEntry(i).getName().equals(_username)){ //TODO: Password check nog toevoegen
                return true;
            }
        }
        return false;
    }
}

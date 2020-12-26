package Controller;

public class LoginController extends AbstractController{


    public LoginController(){

    }

    public Boolean checkIfLoginIsCorrect(String _username, String _password){
        for (int i = 0; i < userDB.getLengthOfDatabase(); i++) {
            if (userDB.getUserEntry(i).getName().equals(_username)){
                if (userDB.getUserEntry(i).checkIfPasswordCorrect(_password.hashCode())) {
                    current_user = i;
                    return true;
                }
            }
        }
        return false;
    }
}

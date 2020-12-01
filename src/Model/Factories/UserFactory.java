package Model.Factories;

import Model.User_related.DefaultUser;
import User_related.Users;

public class UserFactory implements AbstractFactory<User_related.Users> {
    @Override
    public Users create(String choice, String _name, int _id) {
        if ("default".equalsIgnoreCase(choice)){
            return new DefaultUser(_name, _id);
        }
        return null;
    }
}

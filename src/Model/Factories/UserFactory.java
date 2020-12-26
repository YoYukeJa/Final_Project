package Model.Factories;

import Model.User_related.DefaultUser;
import Model.User_related.Users;

public class UserFactory implements AbstractUserFactory<Users> {
    @Override
    public Users create(String choice, String _name, int _id, int hash) {
        if ("default".equalsIgnoreCase(choice)){
            return new DefaultUser(_name, _id, hash);
        }
        return null;
    }
}

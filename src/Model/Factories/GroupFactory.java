package Model.Factories;

import User_related.NormalGroup;

public class GroupFactory implements AbstractFactory<User_related.NormalGroup> {
    @Override
    public User_related.NormalGroup create(String choice, String _name, int _id) {
        if ("normal".equalsIgnoreCase(choice)){
            return new NormalGroup(_name, _id);
        }
        return null;
    }
}

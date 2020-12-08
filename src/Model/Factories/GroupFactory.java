package Model.Factories;

import Model.User_related.NormalGroup;

public class GroupFactory implements AbstractFactory<NormalGroup> {
    @Override
    public NormalGroup create(String choice, String _name, int _id) {
        if ("normal".equalsIgnoreCase(choice)){
            return new NormalGroup(_name, _id);
        }
        return null;
    }
}

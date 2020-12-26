package Model.Factories;

import Model.User_related.Groups;
import Model.User_related.Ticket;

import java.util.List;

public class DefaultFactoryProvider {
    public Object getFactory(String choice, String object_choice, String _name, int _id){
        if ("user".equalsIgnoreCase(choice)){
            this.getUserFactory(object_choice, _name, _id);
        } else if ("group".equalsIgnoreCase(choice)) {
            this.getGroupsFactory(object_choice, _name, _id);
        }
        return null;
    }

    private Model.User_related.Users getUserFactory(String object_choice, String _name, int _id){
        return new UserFactory().create(object_choice, _name, _id);
    }
    private Groups getGroupsFactory(String object_choice, String _name, int _id){
        return new GroupFactory().create(object_choice, _name, _id);
    }
}
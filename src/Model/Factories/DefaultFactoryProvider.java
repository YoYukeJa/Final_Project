package Model.Factories;

import Model.User_related.Groups;
import User_related.Ticket;

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

    private User_related.Users getUserFactory(String object_choice, String _name, int _id){
        return new UserFactory().create(object_choice, _name, _id);
    }
    private Groups getGroupsFactory(String object_choice, String _name, int _id){
        return new GroupFactory().create(object_choice, _name, _id);
    }
    private Ticket getTicketFactory(int _id, int group_id, List<Integer> u_ids, List<Double> user_amounts, Boolean split_evenly, int k){
        return new TicketFactory().create(_id, group_id, u_ids, user_amounts, split_evenly, k);
    }
}

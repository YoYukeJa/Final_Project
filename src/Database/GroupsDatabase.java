package Database;

import Controller.AbstractController;
import Database.Interface.IGroupsDatabase;
import Model.Factories.GroupFactory;
import Model.User_related.Groups;
import Model.User_related.NormalGroup;
import Model.User_related.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class GroupsDatabase extends Database implements IGroupsDatabase {
    protected final Vector<Groups> groupDB;
    private static GroupsDatabase single_instance;
    private List<AbstractController> observersList;

    private GroupsDatabase() {
        this.groupDB = new Vector<>();
        this.observersList = new ArrayList<>();
    }

    public static GroupsDatabase getInstance(){
        if (single_instance == null){
            single_instance = new GroupsDatabase();
        }
        return single_instance;
    }

    @Override
    public Integer addEntry(String _name) {
        int id = generateAuthenticId(groupDB);
        Groups g = new GroupFactory().create("normal", _name, id);
        this.groupDB.add(g);
        return id;
    }

    public void addObserver(AbstractController controller){
        observersList.add(controller);
    }

    public void removeObserver(AbstractController controller){
        observersList.remove(controller);
    }

    @Override
    public void editGroupEntry(Groups g) {
        groupDB.set(g.getIndex(), g);
    }

    @Override
    public Groups getGroupEntry(int id) {
        return groupDB.get(id);
    }

    @Override
    public void addMemberToGroup(int id, Users u) {
        groupDB.get(id).addMember(u.getUserId());
        for (AbstractController controller: observersList
             ) {
            controller.update(this);
        }
    }

    @Override
    public List<Integer> getUsersFromGroup(int id){
        return this.groupDB.get(id).getUsers();
    }

    @Override
    public void addTicketToGroup(int g_id, int ticket_id) {
        Groups g = groupDB.get(g_id);
        g.addPayment(ticket_id);
        editGroupEntry(g);
    }


}

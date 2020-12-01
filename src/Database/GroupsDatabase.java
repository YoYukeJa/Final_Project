package Database;

import Model.User_related.Groups;
import User_related.NormalGroup;
import User_related.Users;

import java.util.List;
import java.util.Vector;

public class GroupsDatabase extends Database implements IGroupsDatabase {
    protected final Vector<Groups> groupDB;

    public GroupsDatabase() {
        this.groupDB = new Vector<>();
    }

    @Override
    public void addEntry(String _name) {
        int id = generateAuthenticId(groupDB);
        Groups g = new NormalGroup(_name, id);
        this.groupDB.add(g);
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
    }

    @Override
    public List<Integer> getUsersFromGroup(int id){
        return this.groupDB.get(id).getUsers();
    }
}

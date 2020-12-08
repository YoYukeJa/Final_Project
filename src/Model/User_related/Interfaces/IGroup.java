package Model.User_related.Interfaces;

import java.util.List;

public interface IGroup {
    void addMember(int userID);
    void deleteMember(int userID);
    void addPayment(int id);
    double getTotalBalance();
    List<Integer> getTicketIDList();
    List<Integer> getUsers();
    String getName();
    int getIndex();
}

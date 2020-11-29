package Interfaces;

import User_related.Ticket;

import java.util.List;

public interface IGroup {
    public void addMember(int userID);
    public void deleteMember(int userID);
    public void addPayment(int id);
    public double getTotalBalance();
    public List<Integer> getTicketIDList();
    public List<Integer> getUsers();
    public String getName();
}

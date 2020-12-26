package Database.Interface;

import Model.User_related.Users;

public interface IUserDatabase extends IDefaultDatabase{
    void editUserEntry(Users u);
    Users getUserEntry(int id);
    void addTicketToUser(int u_id, int ticket_id);
}

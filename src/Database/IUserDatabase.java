package Database;

import User_related.Users;

public interface IUserDatabase {
    void editUserEntry(Users u);
    Users getUserEntry(int id);
}

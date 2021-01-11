package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    User updateUser(User user);

    void deleteUserId (int id);

    User getUserId (int id);

    List<User> getAllUsers();
}

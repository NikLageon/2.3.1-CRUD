package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    User updateUser(User user);

    void deleteUserId (int id);

    Object getUserId (int id);

    List<User> getAllUsers();
}

package web.service;

import web.dao.UserDao;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao (UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Transactional
    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Transactional
    @Override
    public void deleteUserId(int id) {
        userDao.deleteUserId(id);
    }

    @Transactional
    @Override
    public User getUserId(int id) {
        return userDao.getUserId(id);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        userDao.getAllUsers();
        return null;
    }
}

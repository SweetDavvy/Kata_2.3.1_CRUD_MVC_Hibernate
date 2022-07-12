package web.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {

        this.userDao = userDao;
    }

    public void addNewUser(User user) {

        userDao.addUserToDataBase(user);
    }

    @Transactional(readOnly = true)
    public List<User> showAllUsers() {

        return userDao.showAllUsersInDataBase();
    }

    @Transactional(readOnly = true)
    public User showUserById(Long id) {

        return userDao.showUserByIdFromDataBase(id);
    }

    public void updateCurrentUser(User updatedUser) {

        userDao.updateUserInDataBase(updatedUser);
    }

    public void deleteUserById(Long id) {

        userDao.deleteUserByIdInDataBase(id);
    }

}

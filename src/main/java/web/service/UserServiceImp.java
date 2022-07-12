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

    public void add(User user) {

        userDao.add(user);
    }

    @Transactional(readOnly = true)
    public List<User> index() {

        return userDao.index();
    }

    @Transactional(readOnly = true)
    public User show(Long id) {

        return userDao.show(id);
    }

    public void update(User updatedUser) {

        userDao.update(updatedUser);
    }

    public void delete(Long id) {

        userDao.delete(id);
    }

}

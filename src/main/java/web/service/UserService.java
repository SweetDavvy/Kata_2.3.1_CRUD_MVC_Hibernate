package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void addNewUser(User user);
    List<User> showAllUsers();
    User showUserById(Long id);
    void updateCurrentUser(User updatedUser);
    void deleteUserById(Long id);
}

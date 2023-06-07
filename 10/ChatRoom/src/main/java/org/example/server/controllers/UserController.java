package org.example.server.controllers;

import org.example.server.data_access.*;
import org.example.server.models.*;

public class UserController {
    private final UserDAO userDAO;

    public UserController() {
        userDAO = new UserDAO();

    }

    public void addUser(String username) {
        User user = new User(username);
        userDAO.addUser(user);
    }

    public User getUser(String username) {
        return userDAO.getUser(username);
    }

    public void removeUser(String username) {
        userDAO.deleteUser(userDAO.getUser(username));
    }
}

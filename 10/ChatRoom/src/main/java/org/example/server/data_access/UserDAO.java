package org.example.server.data_access;

import org.example.server.models.*;
import java.util.ArrayList;

public class UserDAO {
    private ArrayList<User> users;

    public UserDAO() {
        users = new ArrayList<User>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void deleteUser(User user) {
        users.remove(user);
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }
}

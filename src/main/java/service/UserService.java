package service;

import entity.User;

import java.util.List;

public interface UserService
{
    User addUser(User user);
    void delete(long id);
    User getByUsername(String username);
    User getByEmail(String email);
    User editUser(User user);
    List<User> getAll();
}

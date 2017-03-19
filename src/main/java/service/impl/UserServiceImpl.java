package service.impl;

import entity.User;
import repository.UserRepository;
import service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user)
    {
        User savedUser = userRepository.saveAndFlush(user);
        return savedUser;
    }

    @Override
    public void delete(long id)
    {
        userRepository.delete(id);
    }

    @Override
    public User getByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    @Override
    public User getByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }

    @Override
    public User editUser(User user)
    {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> getAll()
    {
        return userRepository.findAll();
    }
}

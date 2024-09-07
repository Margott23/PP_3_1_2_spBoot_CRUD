package ru.my.crud.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.my.crud.dao.UserDAO;
import ru.my.crud.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDAO.addUser(user);
    }

    @Override
    @Transactional
    public void update(User updateUser) {
        userDAO.updateUser(updateUser);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userDAO.deleteUser(user.getId());
    }
}

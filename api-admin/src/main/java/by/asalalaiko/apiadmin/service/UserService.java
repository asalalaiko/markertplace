package by.asalalaiko.apiadmin.service;

import by.asalalaiko.apiadmin.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User getUser (Integer id);

    User getUserByName(String name);

    boolean addUser(User user) ;

    public void saveUser(User user);

    boolean deleteUser(Integer id);

    List<User> findAllUsers();
}

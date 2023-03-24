package by.asalalaiko.apiadmin.service.imp;

import by.asalalaiko.apiadmin.dto.User;
import by.asalalaiko.apiadmin.repository.UserRepository;
import by.asalalaiko.apiadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class JPAUserService implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //get User by ID
    @Override
    public User getUser(Integer id) {
        Optional<User> userResponse =  userRepository.findById(id);
        User user = userResponse.get();
        return user;
    }
    //get User by Name
    @Override
    public User getUserByName(String name) {
        return userRepository.findByUsername(name);
    }
    //add new User
    @Override
    public boolean addUser(User user) {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return false;
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setBalance(BigDecimal.ZERO);
        user.setDeleted(false);
        user.setLocked(false); // new User don't blocked

        saveUser(user);
        return true;
    }
    //Save user
    @Override
    public void saveUser(User user) {
        userRepository.save(user);

    }
    // delete User - check parameter deleted to TRUE
    @Override
    public boolean deleteUser(Integer id) {
        User user = getUser(id);

        if (user != null) {
            user.setDeleted(true);
            saveUser(user);
            return true;
        }
        return false;
    }
    // locked User - check parameter locked to TRUE
    @Override
    public boolean lockedUser(Integer id) {
        User user = getUser(id);

        if (user != null) {
            user.setLocked(true);
            saveUser(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean replenishUserBalance(Integer id, BigDecimal sum) {
        User user = getUser(id);
        BigDecimal balanse = user.getBalance();
        user.setBalance(balanse.add(sum));
        if (user != null) {
            saveUser(user);
            return true;
        }
        return false;

    }

    //find all Users
    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}

package by.asalalaiko.apiadmin.repository;

import by.asalalaiko.apiadmin.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String login);

}

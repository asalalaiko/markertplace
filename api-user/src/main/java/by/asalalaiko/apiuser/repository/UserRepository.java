package by.asalalaiko.apiuser.repository;


import by.asalalaiko.apiuser.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String login);

}

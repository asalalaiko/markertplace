package by.asalalaiko.apiuser.repository;

import by.asalalaiko.apiuser.dto.Message;
import by.asalalaiko.apiuser.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findByUser(User user);

}

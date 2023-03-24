package by.asalalaiko.apiuser.repository;

import by.asalalaiko.apiuser.dto.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}

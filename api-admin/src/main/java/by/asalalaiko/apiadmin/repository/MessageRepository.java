package by.asalalaiko.apiadmin.repository;

import by.asalalaiko.apiadmin.dto.Message;
import by.asalalaiko.apiadmin.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}

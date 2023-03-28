package by.asalalaiko.apiuser;

import by.asalalaiko.apiuser.dto.Message;
import by.asalalaiko.apiuser.dto.User;
import by.asalalaiko.apiuser.repository.MessageRepository;
import by.asalalaiko.apiuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;



@Service
public class DataFactory {

    @Autowired
    UserService userService;

    @Autowired
    MessageRepository messageRepository;



    User createUser() {
        User user = new User();
        user.setUsername("user");
        user.setPassword("user");
        user.setEmail("email");
        userService.addUser(user);
        return user;
    }

    User createUser(int prefix) {
        User user = new User();
        user.setUsername("user"+prefix);
        user.setPassword("user"+prefix);
        user.setEmail("email"+prefix);
        userService.addUser(user);
        return user;
    }

    Message createMessage(User user, int prefix){
        Message message = new Message();
        message.setTitle("Title mrssage" + prefix);
        message.setText("Text message" + prefix);
        message.setUser(user);
        messageRepository.save(message);
        return message;
    }





}
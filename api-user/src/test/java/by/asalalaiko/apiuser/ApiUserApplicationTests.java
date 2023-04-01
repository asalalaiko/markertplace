package by.asalalaiko.apiuser;

import by.asalalaiko.apiuser.dto.Message;
import by.asalalaiko.apiuser.dto.User;
import by.asalalaiko.apiuser.repository.UserRepository;
import by.asalalaiko.apiuser.service.MessageService;
import by.asalalaiko.apiuser.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class ApiUserApplicationTests {

    @Autowired
    DataFactory dataFactory;
    @Autowired
    UserService userService;
    @Autowired
    MessageService messageService;

    @Test
    void contextLoads() {
    }

    @Test
    void testUserService() {
        User user = dataFactory.createUser();
        assertEquals(userService.getUserByName("user").getUsername(), user.getUsername());
    }

    @Test
    void testMessageService() {
        User user = dataFactory.createUser(2);
        User user1 = dataFactory.createUser(1);
        for(int i = 0; i<100; i++){
            dataFactory.createMessage(user, i);
            dataFactory.createMessage(user1, i);
        }
        assertEquals(messageService.getMessagesByUser(user).size(), 100);
    }


}

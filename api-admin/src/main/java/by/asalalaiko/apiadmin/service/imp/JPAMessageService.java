package by.asalalaiko.apiadmin.service.imp;

import by.asalalaiko.apiadmin.dto.Message;
import by.asalalaiko.apiadmin.dto.User;
import by.asalalaiko.apiadmin.repository.MessageRepository;
import by.asalalaiko.apiadmin.repository.UserRepository;
import by.asalalaiko.apiadmin.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class JPAMessageService implements MessageService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public boolean sendMessage(Message message) {
        Optional<User> userResponse =  userRepository.findById(message.getUser().getId());
        User user = userResponse.get();

        if (user != null) {
            saveMessage(message);
            return true;
        }
        return false;

    }

    @Override
    public void saveMessage(Message message) {
        messageRepository.save(message);

    }
}

package by.asalalaiko.apiuser.service.impl;

import by.asalalaiko.apiuser.dto.Message;
import by.asalalaiko.apiuser.dto.User;
import by.asalalaiko.apiuser.repository.MessageRepository;
import by.asalalaiko.apiuser.repository.UserRepository;
import by.asalalaiko.apiuser.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class JPAMessageService implements MessageService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessageRepository messageRepository;

    @Override
    @Transactional
    public List<Message> getMessagesByUser(User user) {
        Optional<User> userResponse =  userRepository.findById(user.getId());


        if (userResponse != null) {
            return messageRepository.findByUser(user);
        }
        return null;

    }
}

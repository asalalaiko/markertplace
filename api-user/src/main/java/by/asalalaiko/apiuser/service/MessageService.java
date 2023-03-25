package by.asalalaiko.apiuser.service;

import by.asalalaiko.apiuser.dto.Message;
import by.asalalaiko.apiuser.dto.User;

import java.util.List;

public interface MessageService {

    List<Message> getMessagesByUser (User user);
}

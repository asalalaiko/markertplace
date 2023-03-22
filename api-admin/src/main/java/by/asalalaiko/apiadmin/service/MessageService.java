package by.asalalaiko.apiadmin.service;

import by.asalalaiko.apiadmin.dto.Message;

import java.util.Date;

public interface MessageService {
    public void saveMessage(Message message);

    boolean sendMessage(Message message);

}

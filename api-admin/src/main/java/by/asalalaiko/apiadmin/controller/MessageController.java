package by.asalalaiko.apiadmin.controller;

import by.asalalaiko.apiadmin.dto.Message;
import by.asalalaiko.apiadmin.dto.User;
import by.asalalaiko.apiadmin.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping(value = "/message")
    public ResponseEntity<?> create(@RequestBody Message message) {
        final boolean create = messageService.sendMessage(message);
        return create
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.CREATED);
    }
}

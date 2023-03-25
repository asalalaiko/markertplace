package by.asalalaiko.apiuser.controller;

import by.asalalaiko.apiuser.dto.Message;
import by.asalalaiko.apiuser.dto.User;
import by.asalalaiko.apiuser.service.MessageService;
import by.asalalaiko.apiuser.service.UserService;
import by.asalalaiko.apiuser.service.impl.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;
    @Autowired
    private UserAuthService userAuthService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/messages")
    public ResponseEntity<?> create(Authentication authentication) {
        String nameUser = authentication.getName();
        User user = userService.getUserByName(nameUser);
        final List<Message> messageList = messageService.getMessagesByUser(user);

        return messageList!= null &&  ! messageList.isEmpty()
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}

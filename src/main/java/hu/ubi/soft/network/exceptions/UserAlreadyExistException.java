package hu.ubi.soft.network.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String userName) {
        super("User already exists with this name [" + userName + "]. Please choose another name.");
    }
}

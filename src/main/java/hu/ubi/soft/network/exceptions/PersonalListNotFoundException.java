package hu.ubi.soft.network.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonalListNotFoundException extends RuntimeException {
    public PersonalListNotFoundException(Long personalListId) {
        super("Could not find personal list with id [" + personalListId + "]");
    }
}

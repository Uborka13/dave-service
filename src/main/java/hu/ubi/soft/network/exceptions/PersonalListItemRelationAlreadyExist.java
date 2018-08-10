package hu.ubi.soft.network.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PersonalListItemRelationAlreadyExist extends RuntimeException {
    public PersonalListItemRelationAlreadyExist(Long relationId) {
        super("Relation already exist");
    }
}

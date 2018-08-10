package hu.ubi.soft.network.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class BeerItemAlreadyExistInThisList extends RuntimeException {

    public BeerItemAlreadyExistInThisList() {
        super("Relation already exists");
    }
}

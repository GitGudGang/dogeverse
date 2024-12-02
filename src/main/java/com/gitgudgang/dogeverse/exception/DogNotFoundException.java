package com.gitgudgang.dogeverse.exception;

import com.gitgudgang.dogeverse.domain.DatabaseType;
import jakarta.persistence.EntityNotFoundException;

import java.util.UUID;

public class DogNotFoundException extends EntityNotFoundException {
    private static final String idMessage = "Dog with id '%s' not found ";
    private static final String dbMessage = "Dog with id '%s' not found in dbType '%s' ";

    public DogNotFoundException(String id) {
        super(String.format(idMessage, id));
    }
    public DogNotFoundException(UUID id) {
        super(String.format(idMessage, id.toString()));
    }


    public DogNotFoundException(String id, DatabaseType dbType) {
        super(String.format(dbMessage, id, dbType.getName()));
    }

    public DogNotFoundException(UUID id, DatabaseType dbType) {
        super(String.format(dbMessage, id.toString(), dbType.getName()));
    }

    public DogNotFoundException(Exception cause) {
        super(cause);
    }

    public DogNotFoundException(String id, Exception cause) {
        super(String.format(idMessage, id), cause);
    }

    public DogNotFoundException(UUID id, Exception cause) {
        super(String.format(idMessage, id.toString()), cause);
    }
}

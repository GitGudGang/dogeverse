package com.gitgudgang.dogeverse.exception;

import java.util.UUID;

import com.gitgudgang.dogeverse.domain.DatabaseType;

import jakarta.persistence.EntityNotFoundException;

public class TrainerNotFoundException extends EntityNotFoundException {
    private static final String idMessage = "Trainer with id '%s' not found ";
    private static final String dbMessage = "Trainer with id '%s' not found in dbType '%s' ";

    public TrainerNotFoundException(String id) {
        super(String.format(idMessage, id));
    }

    public TrainerNotFoundException(UUID id) {
        super(String.format(idMessage, id.toString()));
    }

    public TrainerNotFoundException(String id, DatabaseType dbType) {
        super(String.format(dbMessage, id, dbType.getName()));
    }

    public TrainerNotFoundException(UUID id, DatabaseType dbType) {
        super(String.format(dbMessage, id.toString(), dbType.getName()));
    }

    public TrainerNotFoundException(Exception cause) {
        super(cause);
    }

    public TrainerNotFoundException(String id, Exception cause) {
        super(String.format(idMessage, id), cause);
    }

    public TrainerNotFoundException(UUID id, Exception cause) {
        super(String.format(idMessage, id.toString()), cause);
    }
}

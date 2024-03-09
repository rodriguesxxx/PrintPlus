package org.ifnmg.printplus.api.exceptions;

public class InvalidSessionException extends Exception {
    public InvalidSessionException() {
        super("Sessão invalida!");
    }
    public InvalidSessionException(String msg) {
        super(msg);
    }
}

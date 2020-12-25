package org.corda.exception;


public class AdventParseException extends RuntimeException{

    public AdventParseException(String message) {
        super( message );
    }

    public AdventParseException(String message, Throwable cause) {
        super( message, cause );
    }
}

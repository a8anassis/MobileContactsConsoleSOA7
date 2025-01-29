package gr.aueb.cf.mobilecontacts.exceptions;

import java.io.Serial;

public class PhoneNumberAlreadyExistsException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    public PhoneNumberAlreadyExistsException(String message) {
        super(message);
    }
}

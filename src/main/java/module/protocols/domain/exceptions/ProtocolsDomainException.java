package module.protocols.domain.exceptions;

import javax.ws.rs.core.Response.Status;

import pt.ist.bennu.core.domain.exceptions.DomainException;

public class ProtocolsDomainException extends DomainException {
    private static final String BUNDLE = null;

    public ProtocolsDomainException(String key, String... args) {
        super(BUNDLE, key, args);
    }

    public ProtocolsDomainException(Status status, String key, String... args) {
        super(status, BUNDLE, key, args);
    }

    public ProtocolsDomainException(Throwable cause, String key, String... args) {
        super(cause, BUNDLE, key, args);
    }

    public ProtocolsDomainException(Throwable cause, Status status, String key, String... args) {
        super(cause, status, BUNDLE, key, args);
    }

}

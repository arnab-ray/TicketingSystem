package ticket.system.models;

public class Ticket {
    private final String id;
    private final String messageType;
    private Status status;
    private String resolvedBy;
    private String verifiedBy;
    private String message;

    public String getId() {
        return this.id;
    }

    public Ticket getTicket() {
        return this;
    }

    public Ticket(String id, String messageType, String message) {
        this.id = id;
        this.messageType = messageType;
        this.status = Status.open;
        this.resolvedBy = null;
        this.verifiedBy = null;
        this.message = message;
    }

    public void assign() {
        this.status = Status.assigned;
    }

    public void resolve(String user, String message) {
        this.status = Status.resolved;
        this.resolvedBy = user;
        this.message = message;
    }

    public void verify(String user) {
        this.status = Status.verified;
        this.verifiedBy = user;
    }

    public void autoResolve() {
        this.status = Status.auto_resolved;
        this.message = messageType.equals("check-wallet-balance") ? "sent automatic SMS to customer" :
                "automatic IVR call made to the customer";
    }

    public Status getStoredStatus() {
        return this.status;
    }

    public String getStatus() {
        return ("Ticket-" + id + " status " + this.status + " comment: " + this.message + " resolvedBy: " +
                this.resolvedBy + " verifiedBy: " + this.verifiedBy);
    }
}

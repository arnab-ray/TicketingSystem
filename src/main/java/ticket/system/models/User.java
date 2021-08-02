package ticket.system.models;

import java.util.Queue;

public abstract class User {
    private final String name;
    private final Role role;
    private final User supervisor;

    public User(String name, Role role, User supervisor) {
        this.name = name;
        this.role = role;
        this.supervisor = supervisor;
    }

    public abstract void assignTicket(Ticket ticket);

    public abstract Ticket resolveTicket(String message);

    public abstract void addTicketBucket(Queue<Ticket> tickets);

    public String getName() {
        return this.name;
    }

    public Role getStatus() {
        return this.role;
    }

    public User getSupervisor() {
        return this.supervisor;
    }
}

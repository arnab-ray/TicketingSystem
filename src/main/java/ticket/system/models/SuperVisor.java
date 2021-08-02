package ticket.system.models;

import java.util.Queue;

public class SuperVisor extends User {
    private Queue<Ticket> tickets;

    public SuperVisor(String name) {
        super(name, Role.Supervisor, null);
    }

    @Override
    public void assignTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    @Override
    public Ticket resolveTicket(String message) {
        Ticket ticket = this.tickets.poll();
        if (ticket != null) {
            ticket.verify(this.getName());
        }

        return ticket;
    }

    public void addTicketBucket(Queue<Ticket> tickets) {
        this.tickets = tickets;
    }
}

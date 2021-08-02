package ticket.system.models;

import java.util.Queue;

public class Employee extends User {
    private Queue<Ticket> tickets;
    public Employee(String name, User supervisor) {
        super(name, Role.Employee, supervisor);
    }

    @Override
    public void assignTicket(Ticket ticket) {
        ticket.assign();
        this.tickets.add(ticket);
    }

    @Override
    public Ticket resolveTicket(String message) {
        Ticket ticket = this.tickets.poll();
        if (ticket != null) {
            ticket.resolve(this.getName(), message);
            this.getSupervisor().assignTicket(ticket);
        }

        return ticket;
    }

    public void addTicketBucket(Queue<Ticket> tickets) {
        this.tickets = tickets;
    }
}

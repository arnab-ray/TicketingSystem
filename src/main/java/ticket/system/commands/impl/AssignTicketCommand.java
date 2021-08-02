package ticket.system.commands.impl;

import ticket.system.commands.TicketCommand;
import ticket.system.models.Status;
import ticket.system.models.Ticket;
import ticket.system.models.User;

import java.util.Queue;

public class AssignTicketCommand implements TicketCommand  {
    private final User user;
    private final Queue<Ticket> tickets;

    public AssignTicketCommand(User user, Queue<Ticket> tickets) {
        this.user = user;
        this.tickets = tickets;
    }

    @Override
    public Ticket execute() {
        Ticket ticket = this.tickets.poll();
        if (ticket != null && ticket.getStoredStatus() == Status.open) {
            this.user.assignTicket(ticket);
            System.out.println("Ticket-" + ticket.getId() + " -> " + this.user.getName());
            this.tickets.add(ticket);
            return ticket;
        } else {
            return null;
        }
    }
}

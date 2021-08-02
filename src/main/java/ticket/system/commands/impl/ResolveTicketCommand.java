package ticket.system.commands.impl;

import ticket.system.commands.TicketCommand;
import ticket.system.models.Ticket;
import ticket.system.models.User;

public class ResolveTicketCommand implements TicketCommand {
    private final User user;
    private final String message;

    public ResolveTicketCommand(User user, String message) {
        this.user = user;
        this.message = message;
    }

    @Override
    public Ticket execute() {
        Ticket ticket = this.user.resolveTicket(message);
        System.out.println("Ticket-" + ticket.getId() + " resolved by " + this.user.getName() + " with comment " + this.message);
        return ticket;
    }
}

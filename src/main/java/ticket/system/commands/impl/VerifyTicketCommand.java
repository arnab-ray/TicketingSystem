package ticket.system.commands.impl;

import ticket.system.commands.TicketCommand;
import ticket.system.models.Ticket;
import ticket.system.models.User;

public class VerifyTicketCommand implements TicketCommand {
    private final User user;

    public VerifyTicketCommand(User user) {
        this.user = user;
    }

    @Override
    public Ticket execute() {
        Ticket ticket = this.user.resolveTicket(null);
        System.out.println("Ticket-" + ticket.getId() + " resolution verified by supervisor "  + this.user.getName());
        return ticket;
    }
}

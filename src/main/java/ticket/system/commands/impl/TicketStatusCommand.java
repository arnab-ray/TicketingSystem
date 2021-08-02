package ticket.system.commands.impl;

import ticket.system.commands.TicketCommand;
import ticket.system.models.Ticket;

public class TicketStatusCommand implements TicketCommand {
    private final Ticket ticket;

    public TicketStatusCommand(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public Ticket execute() {
        System.out.println(this.ticket.getStatus());
        return ticket;
    }
}

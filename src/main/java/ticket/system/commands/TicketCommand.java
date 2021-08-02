package ticket.system.commands;

import ticket.system.models.Ticket;

public interface TicketCommand {
    Ticket execute();
}

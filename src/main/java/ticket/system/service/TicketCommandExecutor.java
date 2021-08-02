package ticket.system.service;

import ticket.system.commands.TicketCommand;
import ticket.system.models.Ticket;

public class TicketCommandExecutor {
    private final TicketCommand ticketCommand;

    public TicketCommandExecutor(TicketCommand ticketCommand) {
        this.ticketCommand = ticketCommand;
    }

    public Ticket executeCommand() {
        return ticketCommand.execute();
    }
}

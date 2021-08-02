package ticket.system.commands.impl;

import ticket.system.commands.TicketCommand;
import ticket.system.models.Ticket;

import java.util.UUID;

public class CreateTicketCommand implements TicketCommand {
    private final String messageType;
    private final String messageDesc;

    public CreateTicketCommand(String messageType, String messageDesc) {
        this.messageType = messageType;
        this.messageDesc = messageDesc;
    }

    @Override
    public Ticket execute() {
        Ticket ticket = new Ticket(UUID.randomUUID().toString(), messageType, messageDesc);
        if (messageType.equals("check-wallet-balance") || messageType.equals("change-language")) {
            ticket.autoResolve();
        }
        return ticket;
    }
}

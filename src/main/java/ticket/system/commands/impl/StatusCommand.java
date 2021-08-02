package ticket.system.commands.impl;

import ticket.system.commands.TicketCommand;
import ticket.system.models.Status;
import ticket.system.models.Ticket;

import java.util.Queue;
import java.util.stream.Collectors;

public class StatusCommand implements TicketCommand {
    private final Queue<Ticket> tickets;

    public StatusCommand(Queue<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public Ticket execute() {
        long openCount = tickets.stream().filter(ticket -> ticket.getStoredStatus() == Status.open).count();
        long assignedCount = tickets.stream().filter(ticket -> ticket.getStoredStatus() == Status.resolved || ticket.getStoredStatus() == Status.assigned).count();
        long closedCount = tickets.stream().filter(ticket -> ticket.getStoredStatus() == Status.auto_resolved || ticket.getStoredStatus() == Status.verified).count();;

        long total = openCount + closedCount + assignedCount;

        System.out.println(openCount + " - OPEN TICKETS\n" + assignedCount + " - ASSIGNED TICKETS\n" + closedCount +
                " - CLOSED TICKETS\n" + total + " - TOTAL TICKETS\n");
        return null;
    }
}

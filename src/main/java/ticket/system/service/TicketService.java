package ticket.system.service;

import ticket.system.commands.impl.AssignTicketCommand;
import ticket.system.commands.impl.CreateTicketCommand;
import ticket.system.commands.impl.ResolveTicketCommand;
import ticket.system.commands.impl.StatusCommand;
import ticket.system.commands.impl.TicketStatusCommand;
import ticket.system.commands.impl.VerifyTicketCommand;
import ticket.system.models.Employee;
import ticket.system.models.SuperVisor;
import ticket.system.models.Ticket;
import ticket.system.models.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TicketService {
    public static void main(String[] args) {
        String command = "random";
        Map<Integer, Ticket> ticketMap = new HashMap<>();

        User supervisor = new SuperVisor("Harry");
        supervisor.addTicketBucket(new LinkedList<>());

        User employee = new Employee("Sam", supervisor);
        employee.addTicketBucket(new LinkedList<>());
        //User employee2 = new Employee("Tom");

        Queue<Ticket> openTickets = new LinkedList<>();

        TicketCommandExecutor ticketCommandExecutor = new TicketCommandExecutor(
                new CreateTicketCommand("others", "Need more details"));
        Ticket ticket = ticketCommandExecutor.executeCommand();
        openTickets.add(ticket);

        ticketCommandExecutor = new TicketCommandExecutor(new StatusCommand(openTickets));
        ticketCommandExecutor.executeCommand();

        ticketCommandExecutor = new TicketCommandExecutor(new AssignTicketCommand(employee, openTickets));
        ticketCommandExecutor.executeCommand();

        ticketCommandExecutor = new TicketCommandExecutor(new TicketStatusCommand(ticket));
        ticketCommandExecutor.executeCommand();

        ticketCommandExecutor = new TicketCommandExecutor(new StatusCommand(openTickets));
        ticketCommandExecutor.executeCommand();

        ticketCommandExecutor = new TicketCommandExecutor(new ResolveTicketCommand(employee, "Voila!"));
        ticketCommandExecutor.executeCommand();

        ticketCommandExecutor = new TicketCommandExecutor(new TicketStatusCommand(ticket));
        ticketCommandExecutor.executeCommand();

        ticketCommandExecutor = new TicketCommandExecutor(new VerifyTicketCommand(supervisor));
        ticketCommandExecutor.executeCommand();

        ticketCommandExecutor = new TicketCommandExecutor(new TicketStatusCommand(ticket));
        ticketCommandExecutor.executeCommand();

        ticketCommandExecutor = new TicketCommandExecutor(new StatusCommand(openTickets));
        ticketCommandExecutor.executeCommand();


        System.out.println("-------Debug------------");
        for (int i = 0; i < openTickets.size(); i++) {
            System.out.println(openTickets.peek().getId());
        }
    }
}

package ua.goit;

import org.hibernate.PropertyValueException;
import ua.goit.config.HibernateConfig;
import ua.goit.model.Ticket;
import ua.goit.service.ClientCrudService;
import ua.goit.service.PlanetCrudService;
import ua.goit.service.TicketCrudService;

public class HibernateCrudUsageExample {
    public static void main(String[] args) {
        TicketCrudService ticketCrudService = new TicketCrudService();
        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();
        Ticket ticketFromMarsToEarth = Ticket.builder()
                .client(clientCrudService.findClientById(1L))
                .planetFrom(planetCrudService.findPlanetById("MARS"))
                .planetTo(planetCrudService.findPlanetById("EARTH"))
                .build();
        ticketCrudService.saveTicket(ticketFromMarsToEarth);
        System.out.println("ticketFromMarsToEarth = " + ticketFromMarsToEarth);
        Ticket ticketWithoutClient = Ticket.builder()
                .planetFrom(planetCrudService.findPlanetById("MARS"))
                .planetTo(planetCrudService.findPlanetById("VENUS"))
                .build();
        try {
            ticketCrudService.saveTicket(ticketWithoutClient);
        } catch (PropertyValueException exception) {
            System.err.println(exception.getMessage());
        }
        Ticket ticketWithNotExistedPlanet = Ticket.builder()
                .client(clientCrudService.findClientById(2L))
                .planetFrom(planetCrudService.findPlanetById("EARTH"))
                .planetTo(planetCrudService.findPlanetById("SOME_PLANET"))
                .build();
        try {
            ticketCrudService.saveTicket(ticketWithNotExistedPlanet);
        } catch (PropertyValueException exception) {
            System.err.println(exception.getMessage());
        }
        HibernateConfig.getInstance().close();
    }
}

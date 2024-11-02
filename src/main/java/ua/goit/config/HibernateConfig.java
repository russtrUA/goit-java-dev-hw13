package ua.goit.config;

import lombok.Getter;
import org.flywaydb.core.Flyway;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.goit.model.Client;
import ua.goit.model.Planet;
import ua.goit.model.Ticket;

@Getter
public class HibernateConfig {
    private static final HibernateConfig INSTANCE;
    private static final String DB_URL = "jdbc:postgresql://localhost:5438/goit-dev18-hw12-db";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "Cnhtkjr84";
    private final SessionFactory sessionFactory;

    static {
        Flyway flyway = Flyway.configure()
                .dataSource(DB_URL, DB_USER, DB_PASSWORD)
                .locations("db/migrations")
                .load();
        flyway.migrate();
        INSTANCE = new HibernateConfig();
    }

    private HibernateConfig() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }

    public static HibernateConfig getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }
}

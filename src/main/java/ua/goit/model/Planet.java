package ua.goit.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "planet")
public class Planet {
    @Id
    private String id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "planetFrom")
    @ToString.Exclude
    private Set<Ticket> ticketsFrom;
    @OneToMany(mappedBy = "planetTo")
    @ToString.Exclude
    private Set<Ticket> ticketsTo;
}

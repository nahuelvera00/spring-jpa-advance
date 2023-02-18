package com.nahuel.springjpaadvance.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client {

    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1,
            initialValue = 999
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne
    private User user;

    @OneToMany( // UNO -> MUCHOS | Un cliente puede tener muchas direcciones.
            fetch = FetchType.LAZY,  //Este atributo determina si a la hora de pedir el cliente trae todos los datos de forma automatica, EAGER: Trae siempre los datos - LAZY: Cuando nosotros lo pidamos
            cascade = CascadeType.ALL
    )
    private Set<Address> addresses = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "client_product",
            joinColumns = {
                    @JoinColumn(name = "fk_client")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "fk_product")
            }
    )
    private Set<Product> products = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Client client = (Client) o;
        return id != null && Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

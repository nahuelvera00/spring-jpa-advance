package com.nahuel.springjpaadvance.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {

    @Id
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1,
            initialValue = 8100
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_sequence"
    )
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

    @ManyToOne( //MUCHOS -> UNO | Las direcciones pueden pertenecer solo a 1 cliente
            fetch = FetchType.LAZY,
            optional = false // Este atributo no puede ser optional, No puede existir una direccion que no pertenesca a ningun cliente.
    )
    @JoinColumn(name = "client_id")
    private Client client;

}

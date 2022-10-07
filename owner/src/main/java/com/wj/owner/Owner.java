package com.wj.owner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Owner {
    @Id
    @SequenceGenerator(
            name = "owner_id_sequence",
            sequenceName = "owner_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "owner_id_sequence"
    )
    private Integer id;
    @Column(unique = true)
    private Integer licensePlate;
    private String name;
}

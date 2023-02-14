package com.system.canteen_management.entity.user_management;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items")
public class Item {
    @Id
    @SequenceGenerator(name = "item_seq_gen", sequenceName = "item_seq_gen", allocationSize = 1)
    @GeneratedValue(generator = "item_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;


    @JoinColumn(name = "customerId", referencedColumnName = "Id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;

}

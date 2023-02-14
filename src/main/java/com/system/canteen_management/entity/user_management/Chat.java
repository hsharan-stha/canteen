package com.system.canteen_management.entity.user_management;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chats")

public class Chat {

    @Id
    @SequenceGenerator(name = "message_seq_gen", sequenceName = "message_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "message_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "message", nullable = false)
    private String message;
}

package org.catmanscodes.sms.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "first_name")
    private String firstName;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(nullable = false,unique = true)
    private String email;
}

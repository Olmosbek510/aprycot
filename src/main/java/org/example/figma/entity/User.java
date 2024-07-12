package org.example.figma.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;

    @OneToOne
    private Attachment attachment;

    @ManyToMany
    private List<Role> roles;

}
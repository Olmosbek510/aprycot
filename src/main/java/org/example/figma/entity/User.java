package org.example.figma.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String firstName;
    private String lastName;
    private String phone;

    @Column(unique = true)
    private String email;
    private String password;

    @OneToOne
    private Attachment attachment;

    @ManyToMany
    private List<Role> roles;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Order> addressList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
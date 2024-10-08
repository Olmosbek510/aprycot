package org.example.figma.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "discount_product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiscountProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    private Integer percent;

    @OneToOne
    private Product product;


}
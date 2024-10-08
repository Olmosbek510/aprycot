package org.example.figma.model.dto.response;

import lombok.*;

import java.util.UUID;

/**
 *DTO for {@link org.example.figma.entity.User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String base64Photo;
}
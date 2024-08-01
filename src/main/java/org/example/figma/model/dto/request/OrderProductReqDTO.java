package org.example.figma.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.UUID;

/**
 * DTO for {@link org.example.figma.entity.OrderProduct}
 */
@Value
@Data
@AllArgsConstructor
public class OrderProductReqDTO {
    Integer amount;
    UUID productId;
}
package org.example.figma.model.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductEditReqDto extends ProductReqDto{
    private UUID id;
}

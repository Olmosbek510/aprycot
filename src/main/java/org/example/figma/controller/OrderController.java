package org.example.figma.controller;

import lombok.RequiredArgsConstructor;
import org.example.figma.dto.AddressDTO;
import org.example.figma.entity.Order;
import org.example.figma.model.dto.request.AddressReqDTO;
import org.example.figma.model.dto.request.OrderProductReqDTO;
import org.example.figma.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/user/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping()
    public ResponseEntity<UUID> saveOrder(@RequestBody List<OrderProductReqDTO> orderProductReqDTOList, @RequestBody AddressReqDTO addressReqDTO){
        return orderService.save(orderProductReqDTOList,addressReqDTO);
    }

    @GetMapping
    public ResponseEntity<List<OrderResDto>> getOrders(){
        return orderService.getAllOrders();
    }


}

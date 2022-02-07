package com.bookstore.allmine.adapters.inbound;

import com.bookstore.allmine.adapters.dtos.OrderDto;
import com.bookstore.allmine.application.domain.Order;
import com.bookstore.allmine.application.domain.PageInfo;
import com.bookstore.allmine.application.ports.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderServicePort;

    @PostMapping(produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<Order> create(@RequestBody @Valid OrderDto orderDto) {
        Order order = new Order();
        BeanUtils.copyProperties(orderDto, order);
        return new ResponseEntity<>(orderServicePort.createOrder(order), HttpStatus.CREATED);
    }

    @PutMapping(produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<Order> update(@RequestBody @Valid OrderDto orderDto) {
        Order order = new Order();
        BeanUtils.copyProperties(orderDto, order);
        return new ResponseEntity<>(orderServicePort.updateOrder(order), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Order> delete(@PathVariable("id") UUID id) {
        orderServicePort.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<?> findAll(@PageableDefault(page = 0,
            size = 5,
            sort = "id",
            direction = Sort.Direction.DESC) Pageable pageable){
        PageInfo pageInfo = new PageInfo();
        BeanUtils.copyProperties(pageable, pageInfo);
        List<Order> orderList = orderServicePort.findAll(pageInfo);
        return new ResponseEntity<>(new PageImpl<Order>(orderList, pageable, orderList.size()), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = {"application/json"})
    public ResponseEntity<Object> findById(@PathVariable(value="id") UUID orderId) {
        Optional<Order> orderModelOptional = orderServicePort.findById(orderId);
        return orderModelOptional.<ResponseEntity<Object>>map(order -> ResponseEntity.status(HttpStatus.OK).body(order))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found."));
    }
}

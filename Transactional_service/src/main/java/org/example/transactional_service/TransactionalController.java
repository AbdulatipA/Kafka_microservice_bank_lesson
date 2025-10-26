package org.example.transactional_service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RequestMapping("/transactional")
@RestController
@RequiredArgsConstructor
public class TransactionalController {
    private final OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable long id) {
       return ResponseEntity.ok(orderService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        orderService.delete(id);
        return ResponseEntity.ok("Пользователь с id: '%s' удален".formatted(id));
    }

    @GetMapping()
    public ResponseEntity<List<Order>> getAll() {
       return ResponseEntity.ok(orderService.findAll());
    }
}

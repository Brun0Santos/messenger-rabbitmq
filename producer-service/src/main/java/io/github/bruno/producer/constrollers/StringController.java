package io.github.bruno.producer.constrollers;

import io.github.bruno.producer.dtos.ProductDto;
import io.github.bruno.producer.services.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class StringController {

    @Autowired
    private StringService service;

    @GetMapping
    public ResponseEntity<String> produces(@RequestParam("message") String message) {
        service.produce(message);
        return ResponseEntity.ok().body("Sending message");
    }

    @PostMapping
    public ResponseEntity<String> products(@RequestBody ProductDto productDto) {
        service.sendToExchangeProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Message send to exchange");
    }
}

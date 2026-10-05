package com.eventdecorator.controller;

import com.eventdecorator.model.Booking;
import com.eventdecorator.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins="http://localhost:5173")
public class BookingController {
    private final BookingService service;
    public BookingController(BookingService service){this.service=service;}

    @PostMapping
    public ResponseEntity<Booking> create(@Valid @RequestBody Booking b){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(b));
    }

    @GetMapping public ResponseEntity<List<Booking>> all(){return ResponseEntity.ok(service.all());}
}

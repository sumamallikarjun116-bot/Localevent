package com.eventdecorator.controller;

import com.eventdecorator.model.Decorator;
import com.eventdecorator.service.DecoratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/decorators")
@CrossOrigin(origins="http://localhost:5173")
public class DecoratorController {
    private final DecoratorService service;
    public DecoratorController(DecoratorService service){this.service=service;}

    @GetMapping public ResponseEntity<List<Decorator>> all(){return ResponseEntity.ok(service.all());}

    @GetMapping("/search")
    public ResponseEntity<List<Decorator>> search(
        @RequestParam(defaultValue="") String eventType,
        @RequestParam(defaultValue="") String location,
        @RequestParam(defaultValue="") String service,
        @RequestParam(required=false) Double budget){
        return ResponseEntity.ok(service.search(eventType,location,service,budget));
    }
}

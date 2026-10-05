package com.eventdecorator.service;

import com.eventdecorator.model.Booking;
import com.eventdecorator.repository.BookingRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository repo;
    public BookingService(BookingRepository repo){this.repo=repo;}
    public Booking create(Booking b){b.setStatus("PENDING");return repo.save(b);}
    public List<Booking> all(){return repo.findAll();}
}

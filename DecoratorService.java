package com.eventdecorator.service;

import com.eventdecorator.model.Decorator;
import com.eventdecorator.repository.DecoratorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DecoratorService {
    private final DecoratorRepository repo;
    public DecoratorService(DecoratorRepository repo){this.repo=repo;}
    public List<Decorator> all(){return repo.findAll();}
    public List<Decorator> search(String eventType,String location,String service,Double budget){
        return repo.search(safe(eventType),safe(location),safe(service),budget==null?0:budget);
    }
    private String safe(String s){return s==null?"":s.trim();}
}

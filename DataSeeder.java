package com.eventdecorator.config;

import com.eventdecorator.model.Decorator;
import com.eventdecorator.repository.DecoratorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import java.util.List;

@Configuration
public class DataSeeder {
    @Bean
    CommandLineRunner seed(DecoratorRepository repo){
        return args -> {
            if(repo.count()>0)return;
            repo.saveAll(List.of(
                new Decorator("Dreamy Events & Florals","Anil Kumar","Wedding,Birthday,Engagement","Nellore","Stage Decoration,Floral,Lighting,Balloon",25000.0,true,"9876543210","dreamy@example.com","https://example.com/dreamy","https://images.unsplash.com/photo-1519225421980-715cb0215aed?auto=format&fit=crop&w=900&q=80",4.8),
                new Decorator("Royal Celebration Decor","Priya Reddy","Wedding,Reception,Engagement","Tirupati","Stage Decoration,Floral,Wedding Theme,Lighting",40000.0,true,"9123456780","royal@example.com","https://example.com/royal","https://images.unsplash.com/photo-1507504031003-b417219a0fde?auto=format&fit=crop&w=900&q=80",4.7),
                new Decorator("Bloom & Bliss","Lakshmi Devi","Birthday,Anniversary,Wedding","Nellore","Floral,Balloon,Birthday Theme",12000.0,true,"9988776655","bloom@example.com","https://example.com/bloom","https://images.unsplash.com/photo-1492684223066-81342ee5ff30?auto=format&fit=crop&w=900&q=80",4.6),
                new Decorator("Celebration Hub","Rahul Varma","Corporate,Wedding,Birthday","Chittoor","Corporate,Lighting,Stage Decoration,Floral",30000.0,true,"9000012345","hub@example.com","https://example.com/hub","https://images.unsplash.com/photo-1497366754035-f200968a6e72?auto=format&fit=crop&w=900&q=80",4.5),
                new Decorator("Golden Petals","Meena Rao","Wedding,Reception,Engagement","Nellore","Floral,Stage Decoration,Traditional Theme",35000.0,true,"9555512345","golden@example.com","https://example.com/golden","https://images.unsplash.com/photo-1523438885200-e635ba2c371e?auto=format&fit=crop&w=900&q=80",4.9)
            ));
        };
    }
}

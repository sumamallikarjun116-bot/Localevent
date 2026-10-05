package com.eventdecorator.model;

import jakarta.persistence.*;

@Entity
@Table(name = "decorators")
public class Decorator {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false) private String businessName;
    @Column(nullable=false) private String ownerName;
    @Column(nullable=false) private String eventTypes;
    @Column(nullable=false) private String location;
    @Column(nullable=false) private String services;
    @Column(nullable=false) private Double startingPrice;
    @Column(nullable=false) private Boolean available;
    @Column(nullable=false) private String phone;
    private String email;
    private String portfolioUrl;
    private String imageUrl;
    private Double rating;

    public Decorator() {}

    public Decorator(String businessName, String ownerName, String eventTypes, String location,
                      String services, Double startingPrice, Boolean available, String phone,
                      String email, String portfolioUrl, String imageUrl, Double rating) {
        this.businessName=businessName; this.ownerName=ownerName; this.eventTypes=eventTypes;
        this.location=location; this.services=services; this.startingPrice=startingPrice;
        this.available=available; this.phone=phone; this.email=email;
        this.portfolioUrl=portfolioUrl; this.imageUrl=imageUrl; this.rating=rating;
    }

    public Long getId(){return id;} public void setId(Long v){id=v;}
    public String getBusinessName(){return businessName;} public void setBusinessName(String v){businessName=v;}
    public String getOwnerName(){return ownerName;} public void setOwnerName(String v){ownerName=v;}
    public String getEventTypes(){return eventTypes;} public void setEventTypes(String v){eventTypes=v;}
    public String getLocation(){return location;} public void setLocation(String v){location=v;}
    public String getServices(){return services;} public void setServices(String v){services=v;}
    public Double getStartingPrice(){return startingPrice;} public void setStartingPrice(Double v){startingPrice=v;}
    public Boolean getAvailable(){return available;} public void setAvailable(Boolean v){available=v;}
    public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
    public String getEmail(){return email;} public void setEmail(String v){email=v;}
    public String getPortfolioUrl(){return portfolioUrl;} public void setPortfolioUrl(String v){portfolioUrl=v;}
    public String getImageUrl(){return imageUrl;} public void setImageUrl(String v){imageUrl=v;}
    public Double getRating(){return rating;} public void setRating(Double v){rating=v;}
}

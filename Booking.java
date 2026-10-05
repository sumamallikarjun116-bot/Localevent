package com.eventdecorator.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="bookings")
public class Booking {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Customer name is required")
    private String customerName;

    @NotBlank(message="Phone number is required")
    @Pattern(regexp="^[6-9]\\d{9}$", message="Enter a valid 10-digit Indian mobile number")
    private String phone;

    @Email(message="Enter a valid email")
    private String email;

    @NotBlank(message="Event type is required") private String eventType;
    @NotBlank(message="Location is required") private String location;

    @NotNull(message="Event date is required")
    @FutureOrPresent(message="Event date cannot be in the past")
    private LocalDate eventDate;

    @NotNull(message="Budget is required")
    @Positive(message="Budget must be greater than zero")
    private Double budget;

    @NotBlank(message="Service is required") private String service;
    @NotNull(message="Decorator is required") private Long decoratorId;
    @NotBlank(message="Payment method is required") private String paymentMethod;
    private String notes;
    private String status="PENDING";
    private LocalDateTime createdAt;

    @PrePersist public void beforeSave(){ createdAt=LocalDateTime.now(); if(status==null)status="PENDING"; }

    public Long getId(){return id;} public void setId(Long v){id=v;}
    public String getCustomerName(){return customerName;} public void setCustomerName(String v){customerName=v;}
    public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
    public String getEmail(){return email;} public void setEmail(String v){email=v;}
    public String getEventType(){return eventType;} public void setEventType(String v){eventType=v;}
    public String getLocation(){return location;} public void setLocation(String v){location=v;}
    public LocalDate getEventDate(){return eventDate;} public void setEventDate(LocalDate v){eventDate=v;}
    public Double getBudget(){return budget;} public void setBudget(Double v){budget=v;}
    public String getService(){return service;} public void setService(String v){service=v;}
    public Long getDecoratorId(){return decoratorId;} public void setDecoratorId(Long v){decoratorId=v;}
    public String getPaymentMethod(){return paymentMethod;} public void setPaymentMethod(String v){paymentMethod=v;}
    public String getNotes(){return notes;} public void setNotes(String v){notes=v;}
    public String getStatus(){return status;} public void setStatus(String v){status=v;}
    public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime v){createdAt=v;}
}

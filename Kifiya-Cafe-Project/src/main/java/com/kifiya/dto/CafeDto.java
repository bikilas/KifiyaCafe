package com.kifiya.dto;

import lombok.Data;
import java.time.LocalTime;
import java.util.List;

@Data
public class CafeDto {
    private Long id;
    private String name;
    private String location;
    private String description;
    private CafeType type;
    private ServiceType serviceType;
    private int capacity;
    private boolean hasOutdoorSeating;
    private boolean hasWifi;
    private boolean hasParking;
    private boolean acceptsReservations;
    private boolean isPetFriendly;
    private boolean hasRestrooms;
    private boolean hasPowerOutlets;
    private boolean hasFoodMenu;
    private boolean hasCoffeeMenu;
    private boolean hasBakeryItems;
    private boolean hasVegetarianOptions;
    private boolean hasVeganOptions;
    private boolean hasGlutenFreeOptions;
    private String phoneNumber;
    private String email;
    private String website;
    private List<String> socialMediaLinks;
    private List<String> paymentMethods;
    private double averageRating;
    private int reviewCount;
    private boolean isOperational;
    private LocalTime openingTime;
    private LocalTime closingTime;
}
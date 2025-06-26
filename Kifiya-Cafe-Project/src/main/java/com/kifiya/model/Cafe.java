package com.kifiya.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kifiya_automated_cafes")
@Data
@NoArgsConstructor
@AllArgsConstructor 
public class Cafe {
    // Enums

    public enum CafeType {
        CAFE, COFFEE_SHOP, BAKERY
    }

    public enum ServiceType {
        SELF_SERVICE, COUNTER_SERVICE, TABLE_SERVICE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CafeType type;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private boolean hasOutdoorSeating;

    @Column(nullable = false)
    private boolean hasWifi;

    @Column(nullable = false)
    private boolean hasParking;

    @Column(nullable = false)
    private boolean acceptsReservations;

    @Column(nullable = false)
    private boolean isPetFriendly;

    @Column(nullable = false)
    private boolean hasRestrooms;

    @Column(nullable = false)
    private boolean hasPowerOutlets;

    @Column(nullable = false)
    private boolean hasFoodMenu;

    @Column(nullable = false)
    private boolean hasCoffeeMenu;

    @Column(nullable = false)
    private boolean hasBakeryItems;

    @Column(nullable = false)
    private boolean hasVegetarianOptions;

    @Column(nullable = false)
    private boolean hasVeganOptions;

    @Column(nullable = false)
    private boolean hasGlutenFreeOptions;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String website;

    @ElementCollection
    private List<String> socialMediaLinks;

    @ElementCollection
    private List<String> paymentMethods;

    @Column(nullable = false)
    private double averageRating;

    @Column(nullable = false)
    private int reviewCount;

    @Column(nullable = false)
    private boolean isOperational;

    @Column(nullable = false)
    private LocalTime openingTime;

    @Column(nullable = false)
    private LocalTime closingTime;

    @OneToMany(mappedBy = "cafe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Menu> menuItems = new ArrayList<>();

    @OneToMany(mappedBy = "cafe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> events = new ArrayList<>();

    @OneToMany(mappedBy = "cafe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Staff> staffMembers = new ArrayList<>();

    @OneToMany(mappedBy = "cafe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    public boolean isCurrentlyOpen() {
        if (!isOperational) return false;
        LocalTime now = LocalTime.now();
        return now.isAfter(openingTime) && now.isBefore(closingTime);
    }

    public boolean hasSpecialDietaryOptions() {
        return hasVegetarianOptions || hasVeganOptions || hasGlutenFreeOptions;
    }
}
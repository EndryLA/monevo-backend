package com.monevo.monevo.models;

import jakarta.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}

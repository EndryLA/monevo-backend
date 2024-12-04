package com.monevo.monevo.models;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY  )
    private Integer id;

    private String username;

    private String email;

    private String password;


}

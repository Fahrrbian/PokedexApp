package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "pokemon")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String imageUrl;


    // Standard-Konstruktor
    public Pokemon() {}

    // Konstruktor mit Parametern
    public Pokemon(String name, String type, String imageUrl) {
        this.name = name;
        this.type = type;
        this.imageUrl = imageUrl;
    }

    public Pokemon(long id, String name) {
		// TODO Auto-generated constructor stub
    	this.id = id;
    	this.name = name;
	}

	// Getter und Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

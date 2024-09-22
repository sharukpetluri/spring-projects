package com.learn.springboot.SpringEcom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String brand;
    private BigDecimal price;
    private String category;
    private String description;
    private int stockQuantity;
    private boolean productAvailable;
    private Date releaseDate;
    private String imageName;
    private String imageType;
    @Lob //Large object
    private byte[] imageData;

}

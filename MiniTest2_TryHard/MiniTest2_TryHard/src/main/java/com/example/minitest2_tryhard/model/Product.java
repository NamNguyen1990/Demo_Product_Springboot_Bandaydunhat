package com.example.minitest2_tryhard.model;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Component
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Khong  null")
    private String name;
    @Min(value=500, message = "Nhập Giá phải lớn hơn 500")
    private int price;


    @Max(value = 999, message = "Nhập số lượng phải nhỏ hơn 1000")
    @Min(value=5, message = "Nhập số lượng phải lớn hơn 5")
    private int quantity;

    @ManyToOne
    private Category category;


    public Product() {
    }

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

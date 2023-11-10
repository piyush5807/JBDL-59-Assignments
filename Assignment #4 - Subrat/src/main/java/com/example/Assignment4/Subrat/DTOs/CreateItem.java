package com.example.Assignment4.Subrat.DTOs;

import com.example.Assignment4.Subrat.Models.Availability;
import com.example.Assignment4.Subrat.Models.Category;
import com.example.Assignment4.Subrat.Models.Item;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Valid
@Builder

public class CreateItem {
    private String name;
    private String description;
    private String brand;

    private int price;

    private Category category;

    private Availability availability;

    public Item to(){
        return Item.builder()
                .name(this.name)
                .description(this.description)
                .brand(this.brand)
                .price(this.price)
                .category(this.category)
                .availability(this.availability)
                .build();
    }

}

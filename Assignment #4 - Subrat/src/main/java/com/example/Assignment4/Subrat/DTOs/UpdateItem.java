package com.example.Assignment4.Subrat.DTOs;

import com.example.Assignment4.Subrat.Models.Availability;
import com.example.Assignment4.Subrat.Models.Category;
import com.example.Assignment4.Subrat.Models.Item;
import jakarta.validation.Valid;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@Valid
@Builder
public class UpdateItem {
    private String name;
    private String description;
    private String brand;

    private int price;

    private Category category;

    private Availability availability;

    @UpdateTimestamp
    private Date updatedOn;


}

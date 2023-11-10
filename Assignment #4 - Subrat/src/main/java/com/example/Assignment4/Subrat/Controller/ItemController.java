package com.example.Assignment4.Subrat.Controller;

import com.example.Assignment4.Subrat.DTOs.CreateItem;
import com.example.Assignment4.Subrat.DTOs.UpdateItem;
import com.example.Assignment4.Subrat.Models.Category;
import com.example.Assignment4.Subrat.Models.Item;
import com.example.Assignment4.Subrat.Service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    ItemService itemService;
    @PostMapping("/item1")
    public Item createItem(@RequestBody @Valid CreateItem createItem){
        return itemService.createItemRequest(createItem);

    }
    @GetMapping("/item1/{itemName}")
    public Item getItem(@PathVariable("itemName") String name){
        return itemService.getItemRequest(name);
    }

    @PutMapping("/item1/{id}")
    public String updateItem(@PathVariable("id") int id, @RequestBody UpdateItem updateItem){
       return  itemService.updateItemRequest(id, updateItem);
    }

    @DeleteMapping("/item1/{ID}")
    public void deleteItem(@PathVariable("ID") int id){
        itemService.deleteItemRequest(id);
    }
    @GetMapping("/item1")
    public List<Item> getAllByCategory(@RequestParam("category")Category ca){
        return itemService.getAllItemByCategory(ca);
    }


}

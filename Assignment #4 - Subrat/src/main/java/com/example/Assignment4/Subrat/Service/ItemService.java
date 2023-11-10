package com.example.Assignment4.Subrat.Service;

import com.example.Assignment4.Subrat.DTOs.CreateItem;
import com.example.Assignment4.Subrat.DTOs.UpdateItem;
import com.example.Assignment4.Subrat.Models.Category;
import com.example.Assignment4.Subrat.Models.Item;
import com.example.Assignment4.Subrat.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public Item createItemRequest(CreateItem createItem){
        Item item = createItem.to();
        Item saveItem = itemRepository.save(item);
        return saveItem;
    }

    public Item getItemRequest(String name){
        return itemRepository.FindName(name);
    }
    public String updateItemRequest(int id,UpdateItem updateItem){
        Optional<Item> optionalItem = itemRepository.findById(id);
        if(optionalItem.isPresent()){
            Item item = optionalItem.get();
           item.setName(updateItem.getName());
           item.setDescription(updateItem.getDescription());
           item.setBrand(updateItem.getBrand());
           item.setPrice(updateItem.getPrice());
           item.setCategory(updateItem.getCategory());
           item.setAvailability(updateItem.getAvailability());
           item.setUpdatedOn(updateItem.getUpdatedOn());
           itemRepository.save(item);
           return "Item is Updated";
        }
        else{
            return  "Item not found";
        }

    }
    public void deleteItemRequest(int id){
        itemRepository.deleteById(id);
    }

    public List<Item> getAllItemByCategory(Category category){
        return itemRepository.findByCategory(category);
    }




}

package com.example.Assignment4.Subrat.Repository;

import com.example.Assignment4.Subrat.Models.Category;
import com.example.Assignment4.Subrat.Models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer>{

    @Query("select i from Item i where i.name = :itemName")
    Item FindName(String itemName);

    Optional<Item> findById(int id);

    List<Item> findByCategory(Category ca);

}

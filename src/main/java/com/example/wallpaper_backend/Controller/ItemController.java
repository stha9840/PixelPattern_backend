package com.example.wallpaper_backend.Controller;

import com.example.wallpaper_backend.Entity.Item;
import com.example.wallpaper_backend.Pojo.ItemPojo;
import com.example.wallpaper_backend.Service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/save")
    public String saveItem(@RequestBody @ModelAttribute ItemPojo itemPojo) throws IOException {
        itemService.saveItem(itemPojo);
        return "Item saved successfully";
    }

    @GetMapping("/getAll")
    public List<Item> getAll() {
        return itemService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<Item> getItemById(@PathVariable("id") Long id) {
        return itemService.getItemById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteItemById(@PathVariable("id") Long id) {
        itemService.deleteItemById(id);
    }
}

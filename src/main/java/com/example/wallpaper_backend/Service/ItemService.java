package com.example.wallpaper_backend.Service;

import com.example.wallpaper_backend.Entity.Item;
import com.example.wallpaper_backend.Pojo.ItemPojo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ItemService {

    void saveItem(ItemPojo itemPojo) throws IOException;

    List<Item> getAll();

    Optional<Item> getItemById(Long id);

    void deleteItemById(Long id);
}

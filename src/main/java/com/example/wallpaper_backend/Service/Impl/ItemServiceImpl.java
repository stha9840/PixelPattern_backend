package com.example.wallpaper_backend.Service.Impl;
import com.example.wallpaper_backend.Entity.Album;
import com.example.wallpaper_backend.Entity.Item;
import com.example.wallpaper_backend.Pojo.ItemPojo;
import com.example.wallpaper_backend.Repo.AlbumRepo;
import com.example.wallpaper_backend.Repo.ItemRepo;
import com.example.wallpaper_backend.Service.ItemService;
import com.example.wallpaper_backend.Util.ImageToBase64;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepo itemRepo;
    private final AlbumRepo albumRepo;

    private final String UPLOAD_DIRECTORY = new StringBuilder().append(System.getProperty("user.dir")).append("/Wallpaper-Images/Item-Images").toString();
    ImageToBase64 imageToBase64 = new ImageToBase64();

    @Override
    public void saveItem(ItemPojo itemPojo) throws IOException {
        Item item;
        if (itemPojo.getItemId() != null) {
            item = itemRepo.findById(itemPojo.getItemId())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found with ID: " + itemPojo.getItemId()));
        } else {
            item = new Item();
        }

        item.setItemName(itemPojo.getItemName());
        item.setDownloadLink(itemPojo.getDownloadLink());

        if (itemPojo.getItemImage() != null) {
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, itemPojo.getItemImage().getOriginalFilename());
            Files.write(fileNameAndPath, itemPojo.getItemImage().getBytes());
        }
        item.setItemImage(itemPojo.getItemImage().getOriginalFilename());

        Album album = albumRepo.findById(itemPojo.getAlbumId())
                .orElseThrow(() -> new EntityNotFoundException("Genre not found with ID: " + itemPojo.getAlbumId()));
        item.setAlbumId(album);

        itemRepo.save(item);
    }

    @Override
    public List<Item> getAll(){
        List<Item> items = itemRepo.findAll();
        items = items.stream().map(item -> {
            item.setItemImage(imageToBase64.getImageBase64("/item-images/" + item.getItemImage()));
            return item;
        }).collect(Collectors.toList());
        return items;
    }

//    @Override
//    public List<Item> getAll(){
//        return itemRepo.findAll();
//    }

    @Override
    public Optional<Item> getItemById(Long id) {
        return itemRepo.findById(id);
    }

    @Override
    public void deleteItemById(Long id) {
        itemRepo.deleteById(id);
    }
}

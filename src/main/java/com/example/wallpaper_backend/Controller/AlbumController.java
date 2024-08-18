package com.example.wallpaper_backend.Controller;

import com.example.wallpaper_backend.Entity.Album;
import com.example.wallpaper_backend.Pojo.AlbumPojo;
import com.example.wallpaper_backend.Service.AlbumService;
import com.example.wallpaper_backend.Service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@RestController
@RequestMapping("album")
@RequiredArgsConstructor
public class AlbumController {
    private final AlbumService albumService;

    @PostMapping("/save")
    public String saveUser(@RequestBody AlbumPojo albumPojo){
        albumService.save(albumPojo);
        return "in this section";
    }

    @GetMapping("/getAll")
    public List<Album> getAll(){
        return this.albumService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<Album> getById(@PathVariable("id") Long id){
        return this.albumService.getById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id){
        this.albumService.deleteById(id);
    }

}

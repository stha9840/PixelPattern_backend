package com.example.wallpaper_backend.Service;

import com.example.wallpaper_backend.Entity.Album;
import com.example.wallpaper_backend.Pojo.AlbumPojo;
import com.example.wallpaper_backend.Entity.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumService {
    void save(AlbumPojo genrePojo);

    List<Album> getAll();

    Optional<Album> getById(Long id);

    void deleteById(Long id);
}

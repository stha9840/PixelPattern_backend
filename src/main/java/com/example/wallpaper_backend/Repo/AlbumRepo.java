package com.example.wallpaper_backend.Repo;

import com.example.wallpaper_backend.Entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepo extends JpaRepository<Album,Long> {

}

package com.example.wallpaper_backend.Service.Impl;

import com.example.wallpaper_backend.Entity.Album;
import com.example.wallpaper_backend.Pojo.AlbumPojo;
import com.example.wallpaper_backend.Repo.AlbumRepo;
import com.example.wallpaper_backend.Service.AlbumService;
import com.example.wallpaper_backend.Entity.Album;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepo albumRepo;

    @Override
    public void save(AlbumPojo albumPojo) {
        Album album = new Album();

        if(albumPojo.getId()!=null){
            album=albumRepo.findById(albumPojo.getId()).get();
        }

        album.setAlbum(albumPojo.getAlbum());
        albumRepo.save(album);
    }


    @Override
    public List<Album> getAll() {
        return albumRepo.findAll(); // select * from genre
    }

    @Override
    public void deleteById(Long id) {
        albumRepo.deleteById(id); // delete from genre where id =?1
    }

    @Override
    public Optional<Album> getById(Long id) {
        return albumRepo.findById(id);
    }

}

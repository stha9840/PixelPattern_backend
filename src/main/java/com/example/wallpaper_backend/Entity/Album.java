package com.example.wallpaper_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="albums")
public class Album {

    @Id
    @SequenceGenerator(name = "albums_seq_gen", sequenceName = "albums_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "albums_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="album", nullable = false, unique = true)
    private String album;
}

package com.example.wallpaper_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name="item")
public class Item {
    @Id
    @SequenceGenerator(name = "items_seq_gen", sequenceName = "items_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "items_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long itemId;

    @Column(name = "item_name", nullable = false, unique = true)
    private String itemName;


    @Column(name = "download_link")
    private String downloadLink;

    @Column(name = "item_image")
    private String itemImage;


    @ManyToOne
    @JoinColumn(name = "album_id", nullable = false)
    private Album albumId;
}

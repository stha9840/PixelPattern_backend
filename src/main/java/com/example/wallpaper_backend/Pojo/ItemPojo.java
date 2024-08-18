package com.example.wallpaper_backend.Pojo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemPojo {

    private Long itemId;

    @NotNull
    private String itemName;


    private String downloadLink;

    private MultipartFile itemImage;

    private Long albumId;  // Assuming genreIds represent the IDs of associated genres
}

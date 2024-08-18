//package com.example.wallpaper_backend;
//import com.example.wallpaper_backend.Entity.Item;
//import com.example.wallpaper_backend.Repo.AlbumRepo;
//import com.example.wallpaper_backend.Repo.ItemRepo;
//import com.example.wallpaper_backend.Util.ImageToBase64;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Rollback;
//@DataJpaTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class ItemRepositoryTest {
//    @Autowired
//    private ItemRepo itemRepo;
//    @Mock
//    private AlbumRepo albumRepo;
//    @Mock    private ImageToBase64 imageToBase64;
//    @Test
//    @Order(1)
//    @Rollback(value = false)
//    public void saveItem(){
//        Item item = new Item();
//        item.setItemName("Item Name1");
//        item.setDownloadLink("https://example.com/download");
//        item.setItemImage(null);
//        item = itemRepo.save(item);
//        Assertions.assertThat(item.getItemId()).isGreaterThan(0);
//    }
//}

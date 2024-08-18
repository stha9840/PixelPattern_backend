//package com.example.wallpaper_backend.Util;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.util.Base64;
//
//public class ImageToBase64 {
//
//    public String getImageBase64(String fileName) {
//        String filePath = System.getProperty("user.dir") + "/Wallpaper-Images/";
//        File file = new File(filePath + fileName);
//        byte[] bytes = new byte[0];
//        try {
//            bytes = Files.readAllBytes(file.toPath());
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//        String base64 = Base64.getEncoder().encodeToString(bytes);
//        return base64;
//    }
//}

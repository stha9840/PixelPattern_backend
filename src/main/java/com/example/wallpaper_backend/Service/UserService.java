package com.example.wallpaper_backend.Service;


import com.example.wallpaper_backend.Entity.User;
import com.example.wallpaper_backend.Pojo.NewPasswordPojo;
import com.example.wallpaper_backend.Pojo.UserPojo;

import java.util.List;
import java.util.Optional;

public interface UserService {

    String save(UserPojo userPojo);

    List<User> getAll();

    void deleteById(Long id);

    Optional<User> getById(Long id);
    Optional<User> getByEmail(String email);
    String setNewPassword(NewPasswordPojo newPasswordPojo);

}

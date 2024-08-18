package com.example.wallpaper_backend.Controller;

import com.example.wallpaper_backend.Entity.User;
import com.example.wallpaper_backend.Pojo.UserPojo;
import com.example.wallpaper_backend.Service.UserService;
import com.example.wallpaper_backend.helper.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

//@CrossOrigin("*")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ApiResponse apiResponse;

    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> save(@Valid @RequestBody UserPojo userPojo){
        return apiResponse.successResponse("Data saved successfully", true, null, userService.save(userPojo));
    }

    @GetMapping("/getAll")
    public List<User> getAll(){

        return this.userService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<User> getById(@PathVariable("id") Long id){

        return this.userService.getById(id);
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id){
        this.userService.deleteById(id);
    }

//    @GetMapping("/getByEmail/{email}")
//    public Optional<User> getByEmail(@PathVariable("email") String email) {
//        return this.userService.getByEmail(email);
//    }
//
//    @PostMapping("/new-password")
//    public String setNewPassword(@RequestBody NewPasswordPojo newPasswordPojo){
//        userService.setNewPassword(newPasswordPojo);
//        return "password changed";
//    }

}

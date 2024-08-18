package com.example.wallpaper_backend.Service.Impl;


import com.example.wallpaper_backend.Config.PasswordEncoderUtil;
import com.example.wallpaper_backend.Entity.User;
import com.example.wallpaper_backend.Pojo.NewPasswordPojo;
import com.example.wallpaper_backend.Pojo.UserPojo;
import com.example.wallpaper_backend.Repo.UserRepository;
import com.example.wallpaper_backend.Service.UserService;
import com.example.wallpaper_backend.security.JwtService;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final JwtService jwtService;
    private final UserRepository userRepository;



    @Override
    public String save(UserPojo userPojo) {
        User user = new User();

        if(userPojo.getId()!=null){
            user=userRepository.findById(userPojo.getId()).get();
        }
        user.setFullName(userPojo.getFullName());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(userPojo.getPassword()));
        user.setEmail(userPojo.getEmail());


        userRepository.save(user); // insert query
        return "Saved Successfully";


    }

    @Override
    public List<User> getAll() {

        return userRepository.findAll(); // select * from users
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id); // delete from users where id =?1
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

//    public List<Map<String, Object>> getAllStudentsWithoutPassword() {
//        List<User> students = userRepository.findAll();
//
//        List<Map<String, Object>> studentsWithoutPassword = new ArrayList<>();
//        for (User student : students) {
//            Map<String, Object> studentMap = new HashMap<>();
//            studentMap.put("userId", student.getUserId());
//            studentMap.put("username", student.getUsername());
//            studentMap.put("email", student.getEmail());
//            studentMap.put("role", student.getRole());
//            // Add other fields as needed
//            studentsWithoutPassword.add(studentMap);
//        }
//
//        return studentsWithoutPassword;
//    }

    public String setNewPassword(NewPasswordPojo newPasswordPojo) {
        String email=jwtService.extractUsername(newPasswordPojo.getToken());
        User user=userRepository.findByEmail(email).get();
        user.setPassword(PasswordEncoderUtil.getInstance().encode(newPasswordPojo.getNewPassword()));
        userRepository.save(user);
        return null;
    }


}

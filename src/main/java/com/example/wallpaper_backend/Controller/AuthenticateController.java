package com.example.wallpaper_backend.Controller;

import com.example.wallpaper_backend.Pojo.AuthenticateRequest;
import com.example.wallpaper_backend.Service.AuthenticateService;
import com.example.wallpaper_backend.helper.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthenticateController {
    private final ApiResponse apiResponse;
    private final AuthenticateService authenticateService;

    @PostMapping("/authenticate")
    public ResponseEntity<Map<String, Object>> authenticate(@RequestBody AuthenticateRequest authenticateRequest) {
        return apiResponse.successResponse(
                "Token generated successfully.",
                true,
                null,
                authenticateService.authenticate(authenticateRequest)
        );
    }
}

//        return apiResponse.successResponse(
//                "Token generated successfully.",

//package com.cosmetobackend.cosmeto.Controller;
//
//import com.cosmetobackend.cosmeto.Pojo.AuthenticateRequest;
//import com.cosmetobackend.cosmeto.Service.AuthenticateService;
//import com.cosmetobackend.cosmeto.helper.ApiResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping
//@RequiredArgsConstructor
//public class AuthenticateController {
//    private final ApiResponse apiResponse;
//    private final AuthenticateService authenticateService;
//
//    @PostMapping("/authenticate")
//    public ResponseEntity<Map<String, Object>> authenticate(@RequestBody AuthenticateRequest authenticateRequest) {
//        return apiResponse.successResponse(
//                "Token generated successfully.",
//                true, null,
//                authenticateService.authenticate(authenticateRequest));
//    }
//}

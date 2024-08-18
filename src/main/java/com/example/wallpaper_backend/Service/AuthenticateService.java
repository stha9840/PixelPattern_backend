package com.example.wallpaper_backend.Service;

import com.example.wallpaper_backend.Pojo.AuthenticateRequest;
import com.example.wallpaper_backend.Pojo.AuthenticationResponse;

public interface AuthenticateService {

    AuthenticationResponse authenticate(AuthenticateRequest authenticateRequest);
}

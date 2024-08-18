package com.example.wallpaper_backend.Service.Impl;

import com.example.wallpaper_backend.Entity.User;
import com.example.wallpaper_backend.Pojo.AuthenticateRequest;
import com.example.wallpaper_backend.Pojo.AuthenticationResponse;
import com.example.wallpaper_backend.Repo.UserRepository;
import com.example.wallpaper_backend.Service.AuthenticateService;
import com.example.wallpaper_backend.security.JwtService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticateServiceImpl implements AuthenticateService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public AuthenticationResponse authenticate(AuthenticateRequest authenticateRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticateRequest.getEmail(), authenticateRequest.getPassword()
                )
        );

        User user =userRepository.findByEmail(authenticateRequest.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("User not found."));

        UserDetails userDetails =(UserDetails) user;

        String jwtToken = jwtService.generateToken(userDetails);
        return AuthenticationResponse.builder().token(jwtToken).userId(user.getId()).isAdmin(user.getId()==1).userName(user.getFullName()).userEmail(user.getEmail()).build();
    }
}

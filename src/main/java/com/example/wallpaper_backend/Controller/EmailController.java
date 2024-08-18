package com.example.wallpaper_backend.Controller;

import com.example.wallpaper_backend.Pojo.EmailRequest;
import com.example.wallpaper_backend.Service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/by-email")
    public void sendEmail(@RequestBody EmailRequest emailRequest) {
        this.emailService.sendCustomerConfirmationEmail(emailRequest);
    }

    @PostMapping("/reset-password")
    public void resetPassword(@RequestBody EmailRequest emailRequest){
        this.emailService.resetPassword(emailRequest);
    }
}

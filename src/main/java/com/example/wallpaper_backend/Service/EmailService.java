package com.example.wallpaper_backend.Service;

import com.example.wallpaper_backend.Pojo.EmailRequest;

public interface EmailService {
    void sendCustomerConfirmationEmail(EmailRequest emailRequest);
    void resetPassword(EmailRequest emailRequest);

}

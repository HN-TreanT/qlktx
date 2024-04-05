package com.qlktx.qlktx.services;

public interface EmailSenderService {
    void sendEmail(String to, String subject, String message);
}

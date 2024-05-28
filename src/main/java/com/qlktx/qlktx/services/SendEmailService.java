package com.qlktx.qlktx.services;

public interface SendEmailService {
    void sendSimpleEmailMessage(String to, String subject, String body);
    void sendEmailPheDuyet(Integer madondangky);
}
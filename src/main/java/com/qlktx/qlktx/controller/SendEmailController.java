package com.qlktx.qlktx.controller;

import com.qlktx.qlktx.dto.PermissionRoleDTO;
import com.qlktx.qlktx.services.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sendemail")
@CrossOrigin("*")
public class SendEmailController {
    @Autowired
    private EmailSenderService emailSenderService;
    @GetMapping("/add")
    public ResponseEntity<Object> create() {
        return  null;
    }
}

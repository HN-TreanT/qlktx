package com.qlktx.qlktx.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {

    private long id;
    private String name;
    private String username;
    private String email;
}
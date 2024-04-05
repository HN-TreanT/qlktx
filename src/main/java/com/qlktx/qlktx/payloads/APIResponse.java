package com.qlktx.qlktx.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class APIResponse {
    private String message;
    private boolean status;
    private Object data;
}

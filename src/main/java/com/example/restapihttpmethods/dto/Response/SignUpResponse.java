package com.example.restapihttpmethods.dto.Response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpResponse {

    private String email;
    private String password;
    private String message;
}

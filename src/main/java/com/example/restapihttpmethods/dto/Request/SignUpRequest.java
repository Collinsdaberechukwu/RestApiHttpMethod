package com.example.restapihttpmethods.dto.Request;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String location;
    private String password;
}

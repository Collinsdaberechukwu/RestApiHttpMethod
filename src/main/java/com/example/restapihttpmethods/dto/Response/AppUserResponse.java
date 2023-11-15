package com.example.restapihttpmethods.dto.Response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String location;
    private String phoneNumber;
}

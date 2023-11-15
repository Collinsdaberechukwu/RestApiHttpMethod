package com.example.restapihttpmethods.dto.Request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateRequest {
    private String firstName;
    private String lastName;
    private String location;

}

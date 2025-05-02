package com.example.bemediasearch.payload.resquest;


import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientRegistrationRequest {
    @NotBlank
    private String name;
    private String description;
    @NotBlank
    private String email;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }
}

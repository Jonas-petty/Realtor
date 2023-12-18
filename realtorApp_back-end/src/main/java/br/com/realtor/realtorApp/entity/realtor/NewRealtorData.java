package br.com.realtor.realtorApp.entity.realtor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record NewRealtorData(
        @NotBlank
        String name,

        String imageURL,
        @NotBlank @Email
        String email,
        @NotBlank @Pattern(regexp = "\\d{9}")
        String phoneNumber
) {
}

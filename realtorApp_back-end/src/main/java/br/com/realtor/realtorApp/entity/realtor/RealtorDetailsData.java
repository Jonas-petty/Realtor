package br.com.realtor.realtorApp.entity.realtor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

public record RealtorDetailsData(
        Long Id,
        @NotBlank
        String name,
        @NotBlank @Email
        String email,

        @NotBlank @Pattern(regexp = "\\d{9}")
        String phoneNumber,
        LocalDateTime createdAt
) {
    public RealtorDetailsData(Realtor realtor) {
        this(realtor.getId(), realtor.getName(), realtor.getEmail(), realtor.getPhoneNumber(), realtor.getCreatedAt());
    }
}

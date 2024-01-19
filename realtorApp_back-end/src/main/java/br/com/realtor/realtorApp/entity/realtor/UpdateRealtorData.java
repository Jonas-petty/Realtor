package br.com.realtor.realtorApp.entity.realtor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UpdateRealtorData (
        @NotNull
        Long id,
        String imageURL,
        String name,
        @Email
        String email,
        String phoneNumber
) {

}

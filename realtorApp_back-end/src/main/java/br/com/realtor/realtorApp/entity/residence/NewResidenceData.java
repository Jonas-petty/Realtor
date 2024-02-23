package br.com.realtor.realtorApp.entity.residence;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record NewResidenceData(
        @NotNull
        Long realtorId,
        @NotBlank @Pattern(regexp = "\\d{8}")
        String CEP,
        @NotNull
        ResidenceType residenceType,
        @NotBlank
        String address,
        String addressComplement,
        @NotNull
        Integer totalBedrooms,
        @NotNull
        Integer totalBathrooms
) {

}

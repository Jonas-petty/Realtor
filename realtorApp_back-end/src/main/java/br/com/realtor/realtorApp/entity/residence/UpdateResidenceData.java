package br.com.realtor.realtorApp.entity.residence;

import jakarta.validation.constraints.NotNull;

public record UpdateResidenceData(
        @NotNull
        Long id,
        String CEP,
        ResidenceType residenceType,
        String address,
        String addressComplement,
        Integer totalBedrooms,
        Integer totalBathrooms

) {

}

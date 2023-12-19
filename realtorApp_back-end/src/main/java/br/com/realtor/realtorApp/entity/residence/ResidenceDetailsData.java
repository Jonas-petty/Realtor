package br.com.realtor.realtorApp.entity.residence;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

public record ResidenceDetailsData(

        Long id,
        String CEP,
        ResidenceKind residenceKind,
        String address,
        String addressComplement,
        Integer totalBedrooms,
        Integer totalBathrooms,
        LocalDateTime createdAt
) {
    public ResidenceDetailsData(Residence residence) {
        this(
                residence.getId(),
                residence.getCEP(),
                residence.getResidenceKind(),
                residence.getAddress(),
                residence.getAddressComplement(),
                residence.getTotalBedrooms(),
                residence.getTotalBathrooms(),
                residence.getCreatedAt()
        );
    }
}

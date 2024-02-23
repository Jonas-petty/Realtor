package br.com.realtor.realtorApp.entity.residence;

import java.time.LocalDateTime;

public record ResidenceDetailsData(

        Long id,
        String CEP,
        ResidenceType residenceType,
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
                residence.getResidenceType(),
                residence.getAddress(),
                residence.getAddressComplement(),
                residence.getTotalBedrooms(),
                residence.getTotalBathrooms(),
                residence.getCreatedAt()
        );
    }
}

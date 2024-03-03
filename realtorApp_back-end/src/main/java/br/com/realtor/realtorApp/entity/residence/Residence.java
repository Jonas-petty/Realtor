package br.com.realtor.realtorApp.entity.residence;

import br.com.realtor.realtorApp.entity.realtor.Realtor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Residence {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Realtor realtor;

    private String CEP;

    @Enumerated(EnumType.STRING)
    private ResidenceType residenceType;

    private String address;
    private String addressComplement;
    private Integer totalBedrooms;
    private Integer totalBathrooms;

    private Boolean isActive;
    @CreationTimestamp
    private LocalDateTime createdAt;

    public void delete() {
        this.isActive = false;
    }

    public void updateInfo(UpdateResidenceData data) {
        if (data.CEP() != null) {
            this.CEP = data.CEP();
        }
        if (data.residenceType() != null) {
            this.residenceType = data.residenceType();
        }
        if (data.address() != null) {
            this.address = data.address();
        }
        if (data.addressComplement() != null) {
            this.addressComplement = data.addressComplement();
        }
        if (data.totalBedrooms() != null) {
            this.totalBedrooms = data.totalBedrooms();
        }
        if (data.totalBathrooms() != null) {
            this.totalBathrooms = data.totalBathrooms();
        }
    }
}

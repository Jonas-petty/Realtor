package br.com.realtor.realtorApp.entity.realtor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Realtor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageURL;

    private String name;
    private String email;
    private String phoneNumber;

    // A List of Houses maybe??? List<Residence> houses - TODO

    private Boolean isActive;
    @CreationTimestamp
    private LocalDateTime createdAt;

    public Realtor(NewRealtorData data) {
        this.name = data.name();
        this.imageURL = data.imageURL();
        this.email = data.email();
        this.phoneNumber = data.phoneNumber();
        this.isActive = true;
    }
}

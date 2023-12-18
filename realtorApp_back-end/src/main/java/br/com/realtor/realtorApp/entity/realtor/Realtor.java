package br.com.realtor.realtorApp.entity.realtor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
public class Realtor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // A profile picture maybe? URL/file - TODO
    private String imageURL;

    private String name;
    private String email;
    private String phoneNumber;

    // A List of Houses maybe??? List<House> houses - TODO

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

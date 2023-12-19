package br.com.realtor.realtorApp.repository;

import br.com.realtor.realtorApp.entity.residence.Residence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidenceRepository extends JpaRepository<Residence, Long> {
}

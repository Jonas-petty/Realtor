package br.com.realtor.realtorApp.repository;

import br.com.realtor.realtorApp.entity.realtor.Realtor;
import br.com.realtor.realtorApp.entity.residence.Residence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResidenceRepository extends JpaRepository<Residence, Long> {
    Page<Residence> findAllByIsActiveTrue(Pageable pageable);

    Page<Residence> findAllByRealtorId(Long id, Pageable pageable);
}

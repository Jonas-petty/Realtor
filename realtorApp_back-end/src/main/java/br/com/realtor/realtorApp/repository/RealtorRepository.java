package br.com.realtor.realtorApp.repository;

import br.com.realtor.realtorApp.entity.realtor.Realtor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealtorRepository extends JpaRepository<Realtor, Long> {
    Page<Realtor> findAllByIsActiveTrue(Pageable pageable);
}

package br.com.realtor.realtorApp.repository;

import br.com.realtor.realtorApp.entity.realtor.Realtor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealtorRepository extends JpaRepository<Realtor, Long> {
}

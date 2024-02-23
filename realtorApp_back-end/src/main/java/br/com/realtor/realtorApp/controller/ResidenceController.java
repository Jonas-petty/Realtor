package br.com.realtor.realtorApp.controller;

import br.com.realtor.realtorApp.entity.residence.NewResidenceData;
import br.com.realtor.realtorApp.entity.residence.ResidenceManager;
import br.com.realtor.realtorApp.repository.ResidenceRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/residence")
public class ResidenceController {

    @Autowired
    private ResidenceRepository repository;

    @Autowired
    private ResidenceManager residenceManager;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid NewResidenceData newResidence, UriComponentsBuilder uriBuilder) {
        var createdResidenceDetails = residenceManager.create(newResidence);
        repository.flush();

        var uri = uriBuilder.path("/repair/{id}").buildAndExpand(createdResidenceDetails.id()).toUri();

        return ResponseEntity.created(uri).body(createdResidenceDetails);

    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var residence = repository.getReferenceById(id);

        residence.delete();

        return ResponseEntity.noContent().build();
    }


}

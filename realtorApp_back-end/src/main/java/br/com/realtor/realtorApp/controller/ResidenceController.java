package br.com.realtor.realtorApp.controller;

import br.com.realtor.realtorApp.entity.realtor.RealtorDetailsData;
import br.com.realtor.realtorApp.entity.residence.NewResidenceData;
import br.com.realtor.realtorApp.entity.residence.ResidenceDetailsData;
import br.com.realtor.realtorApp.entity.residence.ResidenceManager;
import br.com.realtor.realtorApp.entity.residence.ResidenceType;
import br.com.realtor.realtorApp.repository.ResidenceRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    // Post a new Residence to the system
    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid NewResidenceData newResidence, UriComponentsBuilder uriBuilder) {
        var createdResidenceDetails = residenceManager.create(newResidence);
        repository.flush();

        var uri = uriBuilder.path("/repair/{id}").buildAndExpand(createdResidenceDetails.id()).toUri();

        return ResponseEntity.created(uri).body(createdResidenceDetails);
    }

    // Return a pageable JSON with all the active Residences registered on the System
    @GetMapping
    public ResponseEntity<Page<ResidenceDetailsData>> listAll(Pageable pageable) {
        var page = repository.findAllByIsActiveTrue(pageable).map(ResidenceDetailsData::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        if (repository.existsById(id)) {
            var residence = repository.getReferenceById(id);
            return ResponseEntity.ok(new ResidenceDetailsData(residence));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Return all Residences related to a Realtor
    @GetMapping("/realtor/{id}")
    public ResponseEntity<Page<ResidenceDetailsData>> listAllByRealtor(@PathVariable Long id, Pageable pageable) {
        var page = repository.findAllByRealtorId(id, pageable).map(ResidenceDetailsData::new);
        return ResponseEntity.ok(page);
    }

    // Delete a Residence by its ID
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var residence = repository.getReferenceById(id);

        residence.delete();

        return ResponseEntity.noContent().build();
    }

    // Return a list of all the Residence types considered
    @GetMapping("/type")
    public ResponseEntity listResidenceTypes() {
        return ResponseEntity.ok(ResidenceType.values());
    }


}

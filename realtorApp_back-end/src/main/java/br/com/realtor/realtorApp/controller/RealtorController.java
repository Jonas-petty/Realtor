package br.com.realtor.realtorApp.controller;

import br.com.realtor.realtorApp.entity.realtor.NewRealtorData;
import br.com.realtor.realtorApp.entity.realtor.Realtor;
import br.com.realtor.realtorApp.repository.RealtorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/realtor")
public class RealtorController {

    @Autowired
    private RealtorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity post(@RequestBody @Valid NewRealtorData data, UriComponentsBuilder uriBuilder) {
        var realtor = new Realtor(data);

        repository.save(realtor);

        var uri = uriBuilder.path("/realtor/{id}").buildAndExpand(realtor.getId()).toUri();

        //  Change return of realtor to a Record object, for better security - TODO
        return ResponseEntity.created(uri).body(realtor);
    }

}

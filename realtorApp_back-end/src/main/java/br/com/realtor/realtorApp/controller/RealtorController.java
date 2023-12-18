package br.com.realtor.realtorApp.controller;

import br.com.realtor.realtorApp.entity.realtor.RealtorDetailsData;
import br.com.realtor.realtorApp.entity.realtor.NewRealtorData;
import br.com.realtor.realtorApp.entity.realtor.Realtor;
import br.com.realtor.realtorApp.repository.RealtorRepository;
import br.com.realtor.realtorApp.util.RealtorManager;
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
    public ResponseEntity post(@RequestBody @Valid NewRealtorData data, UriComponentsBuilder uriBuilder) throws Exception {
        var realtor = new Realtor(data);

        repository.save(realtor);

        var uri = uriBuilder.path("/realtor/{id}").buildAndExpand(realtor.getId()).toUri();

        return ResponseEntity.created(uri).body(new RealtorDetailsData(realtor));
    }

}

package br.com.creche.api.controller;

import br.com.creche.api.entity.Pet;
import br.com.creche.api.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pets")

public class PetController {
    @Autowired
    private PetService petService;

    @PostMapping
    public ResponseEntity<Pet> cadastrar(@RequestBody Pet pet){

        Pet petSalvo = petService.cadastrarPet(pet);
        return ResponseEntity.status(201).body(petSalvo);

    }

}

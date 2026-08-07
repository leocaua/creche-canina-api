package br.com.creche.api.controller;

import br.com.creche.api.entity.Rotina;
import br.com.creche.api.service.RotinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rotinas")
public class RotinaController {

    @Autowired
    private RotinaService rotinaService;

    @PostMapping
    public ResponseEntity<Rotina> registrarRotina(@RequestBody Rotina rotina){
        Rotina rotinaSalvo = rotinaService.registrarRotina(rotina);
        return
                ResponseEntity.status(201).body(rotinaSalvo);
    }
}

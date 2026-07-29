package br.com.creche.api.controller;

import br.com.creche.api.entity.Agendamento;
import br.com.creche.api.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<Agendamento> criarAgendamento(@RequestBody Agendamento agendamento){
        Agendamento novoAgendamento = agendamentoService.criarAgendamento(agendamento);
        return
                ResponseEntity.status(201).body(novoAgendamento);
    }
}

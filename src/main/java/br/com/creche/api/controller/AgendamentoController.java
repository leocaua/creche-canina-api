package br.com.creche.api.controller;

import br.com.creche.api.entity.Agendamento;
import br.com.creche.api.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Agendamento>> listarAgendamentos(){
        return
                ResponseEntity.ok(agendamentoService.listarTodosAgendamentos());
    }
}

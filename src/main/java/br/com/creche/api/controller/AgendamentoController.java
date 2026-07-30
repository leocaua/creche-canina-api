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

    @PutMapping("/{id}")
    public ResponseEntity<Agendamento> atualizarAgendamento(@PathVariable Long id, @RequestBody Agendamento agendamento){
        Agendamento agendamentoAtualizado = agendamentoService.atualizarAgendamento(id, agendamento);
        return
                ResponseEntity.status(200).body(agendamentoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAgendamento(@PathVariable Long id){
        agendamentoService.deletarAgendamento(id);
        return
                ResponseEntity.noContent().build();
    }
}

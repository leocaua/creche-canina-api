package br.com.creche.api.service;

import br.com.creche.api.entity.Agendamento;
import br.com.creche.api.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public Agendamento criarAgendamento(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> listarTodosAgendamentos() {
        return agendamentoRepository.findAll();
    }

    public Agendamento atualizarAgendamento(Long id, Agendamento agendamentoDadosNovos) {
        Agendamento agendamentoExistente = agendamentoRepository.findById(id).orElseThrow();
        new RuntimeException("Agendamento não encontrado");

        agendamentoExistente.setDataReserva(agendamentoDadosNovos.getDataReserva());
        agendamentoExistente.setHorarioEntrada(agendamentoDadosNovos.getHorarioEntrada());
        agendamentoExistente.setHorarioSaida(agendamentoDadosNovos.getHorarioSaida());
        agendamentoExistente.setStatus(agendamentoDadosNovos.getStatus());
        agendamentoExistente.setValor(agendamentoDadosNovos.getValor());

        return agendamentoRepository.save(agendamentoExistente);

    }
}

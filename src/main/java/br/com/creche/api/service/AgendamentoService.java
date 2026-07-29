package br.com.creche.api.service;

import br.com.creche.api.entity.Agendamento;
import br.com.creche.api.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public Agendamento criarAgendamento(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }
}

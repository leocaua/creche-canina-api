package br.com.creche.api.service;

import br.com.creche.api.entity.Agendamento;
import br.com.creche.api.entity.PagamentoPix;
import br.com.creche.api.repository.AgendamentoRepository;
import br.com.creche.api.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Agendamento criarAgendamento(Agendamento agendamentoSalvo) {

        long vagasOcupadas = agendamentoRepository.countByDataReserva(agendamentoSalvo.getDataReserva());
        boolean jaAgendado = agendamentoRepository.existsByPetIdAndDataReserva(agendamentoSalvo.getPet().getId(),agendamentoSalvo.getDataReserva());

        if(vagasOcupadas >= 18){
            throw new RuntimeException("Capacidade máxima de 18 pets atingida para esta data.");
        }

        if(jaAgendado){
            throw new RuntimeException("Este pet já possui um agendamento para esta data.");
        }

        Agendamento agendamentoCriado = agendamentoRepository.saveAndFlush(agendamentoSalvo);

        PagamentoPix newPagamentoPix = new PagamentoPix();
        newPagamentoPix.setValor(BigDecimal.valueOf(100.00));
        newPagamentoPix.setStatus("PENDENTE");
        newPagamentoPix.setAgendamento(agendamentoCriado);

        pagamentoRepository.save(newPagamentoPix);

        return agendamentoCriado;
    }

    public List<Agendamento> listarTodosAgendamentos() {
        return agendamentoRepository.findAll();
    }

    public Agendamento atualizarAgendamento(Long id, Agendamento agendamentoDadosNovos) {
        Agendamento agendamentoExistente = agendamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));

        agendamentoExistente.setDataReserva(agendamentoDadosNovos.getDataReserva());
        agendamentoExistente.setHorarioEntrada(agendamentoDadosNovos.getHorarioEntrada());
        agendamentoExistente.setHorarioSaida(agendamentoDadosNovos.getHorarioSaida());
        agendamentoExistente.setStatus(agendamentoDadosNovos.getStatus());
        agendamentoExistente.setValor(agendamentoDadosNovos.getValor());

        return agendamentoRepository.save(agendamentoExistente);

    }

    public void deletarAgendamento(Long id){
        agendamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));

        agendamentoRepository.deleteById(id);
    }

    public Long consultarVagasDisponiveis(LocalDate data){
        long vagaDisponivel = agendamentoRepository.countByDataReserva(data);
        long livre = 18 - vagaDisponivel;
        return livre;
    }

    public List<Agendamento> listarPorData(LocalDate data){
        List<Agendamento> agendamentoEncontrado = agendamentoRepository.findByDataReserva(data);

        return agendamentoEncontrado;
    }

    public Agendamento buscarPorId(Long id){
        agendamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não encontrado"));

        return
                agendamentoRepository.save(agendamentoRepository.findById(id).get());
    }
}

package br.com.creche.api.service;

import br.com.creche.api.entity.PagamentoPix;
import br.com.creche.api.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<PagamentoPix> listarPagamentoPix() {
        return pagamentoRepository.findAll();
    }

    public PagamentoPix atualizarPagamento(Long id) {
        PagamentoPix pagamentoExistente = pagamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));

        pagamentoExistente.setStatus("PAGO");
        pagamentoExistente.setDataPagamento(LocalDateTime.now());
        pagamentoRepository.save(pagamentoExistente);

        return pagamentoExistente;
    }
}

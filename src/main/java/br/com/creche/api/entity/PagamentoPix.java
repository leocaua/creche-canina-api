package br.com.creche.api.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class PagamentoPix {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valor;
    private String status;
    private LocalDateTime dataPagamento;

    @OneToOne
    @JoinColumn(name = "agendamento_id")
    private Agendamento agendamento;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }
    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }
    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }
}

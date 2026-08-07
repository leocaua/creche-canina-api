package br.com.creche.api.service;

import br.com.creche.api.entity.Rotina;
import br.com.creche.api.repository.RotinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RotinaService {

    @Autowired
    private RotinaRepository rotinaRepository;

    public Rotina registrarRotina(Rotina rotina){
        return rotinaRepository.save(rotina);
    }
}

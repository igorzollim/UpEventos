/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.prog3.servidor.modelo.rn;

import br.edu.ifrs.restinga.prog3.servidor.erro.RNInvalida;
import br.edu.ifrs.restinga.prog3.servidor.modelo.entidade.Evento;
import br.edu.ifrs.restinga.prog3.servidor.modelo.entidade.Tema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author igor
 */
@Component
public class EventoRN {
    
    private void valida(Evento evento){
        if(evento.getNome()==null || evento.getNome().equals("")){
            throw new RNInvalida("O campo Nome é obrigatório!");
        }
        
        if(evento.getData() == null){
            throw new RNInvalida("O campo Data é obrigatório!");
        }
        
        if(horaEntradaMenorHoraSaida(evento.getHorario_abertura(), evento.getHorario_fechamento())){
            throw new RNInvalida("O horário de abertura não pode ser maior que o horário de fechamento!");
        }
        
        if(evento.getDesc_evento()==null || evento.getDesc_evento().equals("")){
            throw new RNInvalida("O campo Descricao do evento é obrigatorio!");
        }
        
        if(evento.getFaixa_etaria()==0){
            throw new RNInvalida("O campo faixa etária é obrigatório!");
        }
        
        if(evento.getHorario_abertura()==null || evento.getHorario_abertura().equals("")){
            throw new RNInvalida("O campo Horario abertura é obrigatório!");
        }
        
        if(evento.getHorario_fechamento()==null || evento.getHorario_fechamento().equals("")){
            throw new RNInvalida("O campo Horario fechamento é obrigatório!");
        }  
        
        if(evento.getValor_entrada() <= 0){
            throw new RNInvalida("O valor da entrada deve ser maior que 0");
        }
        
        if(evento.getTags()==null || evento.getTags().equals("")){
            throw new RNInvalida("O campo Tag é obrigátorio!");
        }
        
        validaTemas(evento, evento.getTemas());
        
    }
    
    private Boolean horaEntradaMenorHoraSaida(String horaE, String horaS){
        String arrayHoraE[] = horaE.split(":");
        String arrayHoraS[] = horaS.split(":");
        
        if(Integer.parseInt(arrayHoraE[0]) > Integer.parseInt(arrayHoraS[0]) ){
            return true;
        }
        return false;
    }
    
    private void validaTemas(Evento evento, Tema[] temas){
        if(temas != null){
            //Valida se existe temas iguais
            if(temasIguais(temas)){
                throw new RNInvalida("Um evento não pode ter temas repetidos!");
            }
            for (int i = 0; i < temas.length; i++) {
                
                if(temas[i].getEstilo_musical() == null || temas[i].getEstilo_musical().equals("")){
                    throw new RNInvalida("O campo Estilo musical é obrigatorio!");
                }
                
                if(temas[i].getEstilo_musical()== null || temas[i].getTipo_comida().equals("")){
                    throw new RNInvalida("O campo Tipo de comida é obrigatorio!");
                }
                
                //valida se o evento tem bebida alcoolica e verifica se a faixa etaria é maior de 18 anos
                if(temas[i].getBebida_alcoolica() == true && evento.getFaixa_etaria() < 18){
                    throw new RNInvalida("A faixa etária deve ser maior de 18 anos para eventos com bebida alcoolica!");
                }
            }
        }
    }
    
    private Boolean temasIguais(Tema[] temas){
        for (int i = 0; i < temas.length; i++) {
            for (int j = 0; j < temas.length; j++) {
                if (i != j){
                    if(temas[i].getBebida_alcoolica() == temas[j].getBebida_alcoolica() &&
                       temas[i].getPista_danca() == temas[j].getPista_danca() &&
                       temas[i].getTipo_comida().equals(temas[j].getTipo_comida()) &&
                       temas[i].getEstilo_musical().equals(temas[j].getEstilo_musical())){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public void validaInsercao(Evento evento){
        valida(evento);
    }
    
    public void validaAtualizacao(Evento evento){
        valida(evento);
    }
}

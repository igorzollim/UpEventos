/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.prog3.servidor.controle;

import br.edu.ifrs.restinga.prog3.servidor.modelo.dao.EventoDAO;
import br.edu.ifrs.restinga.prog3.servidor.modelo.entidade.Evento;
import br.edu.ifrs.restinga.prog3.servidor.modelo.rn.EventoRN;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author igor
 */
@Controller
public class EventoControle {
    @Autowired
    EventoDAO eventoDAO;
    
    @Autowired
    EventoRN eventoRN;
    
    @RequestMapping("/insereEvento")
    @ResponseBody
    public Evento insereEvento(@RequestBody Evento evento)throws SQLException{
        eventoRN.validaInsercao(evento);
        Evento eventoBanco = eventoDAO.inserir(evento);
        return eventoBanco;
    }
    
    @RequestMapping("/mostraEventos")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Evento> mostraEvento() {
        return eventoDAO.listar();
    }
    
    @RequestMapping("/pesquisaEventos")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Evento> pesquisaEvento(@RequestParam String tagsBusca) {
        return eventoDAO.pesquisarEvento(tagsBusca);
    }
    
    @RequestMapping("/alteraEvento")
    @ResponseBody
    public Evento alteraEvento(@RequestParam int id, @RequestBody Evento evento){
        eventoRN.validaAtualizacao(evento);
        return eventoDAO.atualizar(id, evento);
    }
    
    @RequestMapping("/excluiEvento")
    @ResponseBody
    public void excluiEvento(@RequestParam int id) {
        eventoDAO.excluir(id);
    }
}

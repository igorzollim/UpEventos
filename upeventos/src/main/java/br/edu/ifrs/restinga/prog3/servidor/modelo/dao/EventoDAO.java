/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.prog3.servidor.modelo.dao;

import br.edu.ifrs.restinga.prog3.servidor.modelo.entidade.Evento;
import br.edu.ifrs.restinga.prog3.servidor.modelo.entidade.Tema;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

/**
 *
 * @author igor
 */
@Component
public class EventoDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Autowired
    EventoTemaDAO EventoTemaDAO;
    
    private void eventoJaOcorreu(){
    
    }
    public Evento inserir(Evento evento){
        String sql = "INSERT INTO evento(nome, valor_entrada,data, faixa_etaria,horario_abertura,horario_fechamento,desc_evento, tags)VALUES(?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, evento.getNome(), evento.getValor_entrada(), evento.getData(), evento.getFaixa_etaria(), evento.getHorario_abertura(), evento.getHorario_fechamento(),evento.getDesc_evento(), evento.getTags());
        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        
        evento.setId(id);
        
        EventoTemaDAO.inserir(evento.getId(), evento.getTemas());   
        return evento; 
    }
    
    private Evento criaEvento(SqlRowSet rowSet) throws DataAccessException, InvalidResultSetAccessException{
        Evento evento = new Evento();
        evento.setId(rowSet.getInt("id"));
        
        evento.setData(rowSet.getDate("data"));
        
        evento.setDesc_evento(rowSet.getString("desc_evento"));
        evento.setFaixa_etaria(rowSet.getInt("faixa_etaria"));
        evento.setHorario_abertura(rowSet.getTime("horario_abertura").toString());
        evento.setHorario_fechamento(rowSet.getTime("horario_fechamento").toString());
        evento.setNome(rowSet.getString("nome"));
        evento.setValor_entrada(rowSet.getDouble("valor_entrada"));
        evento.setTags(rowSet.getString("tags"));
        
        Tema[] temas = EventoTemaDAO.recuperar(evento.getId());
        evento.setTemas(temas);
        
        return evento;
    }
    
    public List<Evento> listar(){
        ArrayList<Evento> eventos = new ArrayList<>();
        SqlRowSet rowSet = 
                jdbcTemplate.queryForRowSet("Select * from evento");
        
        while(rowSet.next()){
            Evento evento = criaEvento(rowSet);
            eventos.add(evento);
        }
        return eventos;
    }
    
    private java.util.Date getPegaDataAtual() {
		Calendar calendar = new GregorianCalendar();
		java.util.Date date = new java.util.Date();
		calendar.setTime(date);
                
		return calendar.getTime();
    }
    
    private String getDateTime() { 
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
	java.util.Date date = new java.util.Date(); 
	return dateFormat.format(date); 
}
    
    private Boolean tagsIguais(String tagsBusca, String tagsEvento){
        //Com esse metodo vamos buscar um evento com as mesmas tags que o usuario inseriu na caixa de pesquisa
        
              
        String[] tagsBuscaArray = tagsBusca.split(",");
        String[] tagsEventoArray = tagsEvento.split(",");
        
        for (int i = 0; i < tagsBuscaArray.length; i++) {
            for (int j = 0; j < tagsEventoArray.length; j++) {
                if(tagsBuscaArray[i].equals(tagsEventoArray[j]) ){
                    return true;
                }
            }
        }
        return false;
    }
    
    public List<Evento> pesquisarEvento(String tagsBusca){
        ArrayList<Evento> eventos = new ArrayList<>();
        SqlRowSet rowSet = 
                jdbcTemplate.queryForRowSet("Select * from evento");
        
        while(rowSet.next()){
            if(tagsIguais(tagsBusca, rowSet.getString("tags") )){
                Date data = rowSet.getDate("data");
            
                java.util.Date hoje = getPegaDataAtual();

                if(data.compareTo(hoje) < 0 ){
                    continue;
                }
                Evento evento = criaEvento(rowSet);
                eventos.add(evento);
            }
        }
        return eventos;
    }
    
    public Evento atualizar(int id, Evento evento){
        jdbcTemplate.update(
        "UPDATE evento SET nome=?, valor_entrada=?,data=?,faixa_etaria=?,horario_abertura=?, horario_fechamento=?,desc_evento=?, tags=? WHERE id=?",
        evento.getNome(), evento.getValor_entrada(), evento.getData(),evento.getFaixa_etaria(), evento.getHorario_abertura(), evento.getHorario_fechamento(), evento.getDesc_evento(), evento.getTags(),evento.getId());
        
        EventoTemaDAO.atualizar(evento.getId(), evento.getTemas());
        return evento;
    }
    
    public void excluir(int id){
        Evento evento = recuperar(id);
        jdbcTemplate.update("DELETE FROM evento WHERE id=?", id);
    }
    
    public Evento recuperar(int id){
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet("SELECT * FROM evento WHERE id=?", id);
        if(rowSet.next()){
            Evento evento = criaEvento(rowSet);
            return evento;
        }else{
            return null;
        }
    }
    
    
    
}

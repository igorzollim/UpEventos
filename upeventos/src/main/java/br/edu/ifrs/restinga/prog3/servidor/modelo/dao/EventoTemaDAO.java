/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.prog3.servidor.modelo.dao;

import br.edu.ifrs.restinga.prog3.servidor.modelo.entidade.Tema;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

/**
 *
 * @author igor
 */
@Component
public class EventoTemaDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    private Tema inserir(int eventoId, Tema tema){
        String sql = "INSERT INTO evento_tema(id_evento, bebida_alcoolica, pista_danca, estilo_musical,tipo_comida)VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, eventoId, tema.getBebida_alcoolica(), tema.getPista_danca(), tema.getEstilo_musical(), tema.getTipo_comida());
        
        int id = jdbcTemplate.queryForObject(
                "SELECT LAST_INSERT_ID()", Integer.class);
        tema.setId(id);
        return tema;
    }
    
    public Tema[] inserir (int eventoId, Tema temas[]){
        if(temas == null){
            return null;
        }
        Tema[] temasBanco = new Tema[temas.length];
        
        for (int i = 0; i < temas.length; i++) {
            temasBanco[i] = this.inserir(eventoId, temas[i]);
        }
        return temasBanco;
    }
    
    private Tema criaTema(SqlRowSet rowSet){
        Tema tema = new Tema();
        
        tema.setId(rowSet.getInt("id"));
        tema.setBebida_alcoolica(rowSet.getBoolean("bebida_alcoolica"));
        tema.setEstilo_musical(rowSet.getString("estilo_musical"));
        tema.setTipo_comida(rowSet.getString("tipo_comida"));
        tema.setPista_danca(rowSet.getBoolean("pista_danca"));
        
        return tema;
    }
    
    public Tema[] recuperar (int eventoId){
        ArrayList<Tema> temas = new ArrayList<>();
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet("SELECT * FROM evento_tema WHERE id_evento=?", eventoId);
        
        while(rowSet.next()){
            Tema tema = criaTema(rowSet);
            temas.add(tema);
        }
        
        return temas.toArray(new Tema[0]);
    }
    
    public Tema atualizar(Tema tema){
       jdbcTemplate.update(
       "UPDATE evento_tema SET bebida_alcoolica=?, pista_danca=?, estilo_musical=?, tipo_comida=? WHERE id=?",
       tema.getBebida_alcoolica(), tema.getPista_danca(), tema.getEstilo_musical(), tema.getTipo_comida(), tema.getId());
       
       return  tema;
    }
    
    public Tema[] atualizar(int eventoId, Tema[] temasNovos){
        ArrayList<Integer> ids = new ArrayList<>();
        Tema[] temaAntigo = recuperar(eventoId);
        if(temasNovos != null){
            for (int i = 0; i < temasNovos.length; i++) {
                if(temasNovos[i].getId() != 0){
                    temasNovos[i] = this.atualizar(temasNovos[i]);
                }else{
                    temasNovos[i] = this.inserir(eventoId, temasNovos[i]);
                }
                ids.add(temasNovos[i].getId());
            }
        }
        
        for(Tema tema: temaAntigo){
            if(!ids.contains(tema.getId())){
                jdbcTemplate.update("DELETE FROM evento_tema WHERE id=?", tema.getId());
            }
        }
        
        return temasNovos;
    }
}

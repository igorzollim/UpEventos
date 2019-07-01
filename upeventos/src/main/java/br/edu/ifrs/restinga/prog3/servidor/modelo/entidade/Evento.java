/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.prog3.servidor.modelo.entidade;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author igor
 */
public class Evento {

    public String getNome() {
        return nome;
    }

    public double getValor_entrada() {
        return valor_entrada;
    }

    public Date getData() {
        return data;
    }

    public int getFaixa_etaria() {
        return faixa_etaria;
    }

    public String getHorario_abertura() {
        return horario_abertura;
    }

    public String getDesc_evento() {
        return desc_evento;
    }

    public Tema[] getTemas() {
        return temas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor_entrada(double valor_entrada) {
        this.valor_entrada = valor_entrada;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setFaixa_etaria(int faixa_etaria) {
        this.faixa_etaria = faixa_etaria;
    }

    public void setHorario_abertura(String horario_abertura) {
        this.horario_abertura = horario_abertura;
    }

    public void setDesc_evento(String desc_evento) {
        this.desc_evento = desc_evento;
    }

    public void setTemas(Tema[] temas) {
        this.temas = temas;
    }
    private String nome;
    private double valor_entrada;
    private Date data;
    private int faixa_etaria;
    private String horario_abertura;

    public String getHorario_fechamento() {
        return horario_fechamento;
    }

    public void setHorario_fechamento(String horario_fechamento) {
        this.horario_fechamento = horario_fechamento;
    }
    private String horario_fechamento;
    private String desc_evento;
    private Tema[] temas;

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
    private String tags;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private int id;
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.prog3.servidor.modelo.entidade;

/**
 *
 * @author igor
 */
public class Tema {

    public boolean getBebida_alcoolica() {
        return bebida_alcoolica;
    }

    public boolean getPista_danca() {
        return pista_danca;
    }

    public String getEstilo_musical() {
        return estilo_musical;
    }

    public String getTipo_comida() {
        return tipo_comida;
    }

    public void setBebida_alcoolica(boolean bebida_alcoolica) {
        this.bebida_alcoolica = bebida_alcoolica;
    }

    public void setPista_danca(boolean pista_danca) {
        this.pista_danca = pista_danca;
    }

    public void setEstilo_musical(String estilo_musical) {
        this.estilo_musical = estilo_musical;
    }

    public void setTipo_comida(String tipo_comida) {
        this.tipo_comida = tipo_comida;
    }
    private boolean bebida_alcoolica;
    private boolean pista_danca;
    private String estilo_musical;
    private String tipo_comida;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private int id;


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author felipedania
 */
public class Palestra {

    private String titulo, descricao;
    private int dia;
    private Palestrante palestrante;
    Integer id;

    public Palestra() {
    }

    public Palestra(String titulo, String descricao, int dia, Integer id, Palestrante palestrante) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dia = dia;
        this.id = id;
        this.palestrante = palestrante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public Palestrante getPalestrante() {
        return palestrante;
    }

    public void setPalestrante(Palestrante palestrante) {
        this.palestrante = palestrante;
    }

    @Override
    public String toString() {
        return getTitulo();
    }

        
}

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
public class Aluno {
    
    private String nome, nomeCurso;
    private int faseCurso;
    Integer id;

    public Aluno() {
    }

    public Aluno(String nome, String nomeCurso, Integer id, int faseCurso) {
        this.nome = nome;
        this.nomeCurso = nomeCurso;
        this.id = id;
        this.faseCurso = faseCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getFaseCurso() {
        return faseCurso;
    }

    public void setFaseCurso(int faseCurso) {
        this.faseCurso = faseCurso;
    }
    
    
}

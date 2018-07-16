/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.Date;

/**
 *
 * @author dhyeg
 */
public class Relatorio {

    private Integer id;
    private Aluno aluno;
    private Palestra palestra;
    private Date data;

    public Relatorio() {
    }

    public Relatorio(Integer id, Aluno aluno, Palestra palestra) {
        this.id = id;
        this.aluno = aluno;      
        this.palestra = palestra;
       
    }
  
    public Palestra getPalestra() {
        return palestra;
    }

    public void setPalestra(Palestra palestra) {
        this.palestra = palestra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    
    
}

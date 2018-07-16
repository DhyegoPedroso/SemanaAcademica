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
public class Palestrante {

    private String nome, nomePalestra;
    private int dataPalestra;
    Integer id;

    public Palestrante() {
    }

    public Palestrante(String nome, String nomePalestra, Integer id, int dataPalestra) {
        this.nome = nome;
        this.nomePalestra = nomePalestra;
        this.id = id;
        this.dataPalestra = dataPalestra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomePalestra() {
        return nomePalestra;
    }

    public void setNomePalestra(String nomePalestra) {
        this.nomePalestra = nomePalestra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDataPalestra() {
        return dataPalestra;
    }

    public void setDataPalestra(int dataPalestra) {
        this.dataPalestra = dataPalestra;
    }

}

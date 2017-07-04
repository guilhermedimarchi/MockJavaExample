/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.value.projects.dominio;

/**
 *
 * @author Guilherme
 */
public class Correntista {
    
    String nome;
    String CPF;
    Conta conta;

    
    public Correntista(Conta conta) {
        this.conta = conta;
    }
    
    public Conta getConta() {
        return conta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    
    
    
}

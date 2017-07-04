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
public class Conta {
    
    double saldo;
    double limite;
    String numeroConta;
    boolean status;
   

    public boolean podeSacar(double valor) {
        return valor <= saldo + limite;
    }
    
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setConta(String conta) {
        this.numeroConta = conta;
    }
    
    
    
    
    
    
}

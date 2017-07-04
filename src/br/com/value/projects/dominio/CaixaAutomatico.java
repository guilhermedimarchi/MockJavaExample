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
public class CaixaAutomatico {
    
    int id;
    double saldo;
    Correntista c;

    public void logar(Correntista c) {
        this.c = c;
    }
    
    public void deslogar() {
        this.c = null;
    }
    
    public boolean isLogado() {
        return c != null;
    }

    public void sacar(double valor) {
        saldo -= valor;
        Conta conta = c.getConta();
        conta.setSaldo(conta.getSaldo() - valor);
    }
    
    public boolean podeSacar(double valorSolicitado)
    {
        return valorSolicitado <= saldo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
    
}

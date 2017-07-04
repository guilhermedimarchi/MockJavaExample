/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.value.projects.service;

/**
 *
 * @author Guilherme
 */
import br.com.value.projects.dominio.CaixaAutomatico;
import br.com.value.projects.dominio.Conta;
import br.com.value.projects.dominio.Correntista;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TesteSaque {

    BancoDaoFalso dao;
    CaixaAutomatico caixa;
    Conta c;
    Correntista correntista;
    

    @Before
    public void initialize() {
        dao = mock(BancoDaoFalso.class);

        caixa = new CaixaAutomatico();
        caixa.setId(1);
        caixa.setSaldo(10000);
        when(dao.getCaixa()).thenReturn(caixa);

        c = new Conta();
        c.setConta("00001");
        c.setLimite(500);
        c.setSaldo(1000);
        c.setStatus(true);
        correntista = new Correntista(c);
        correntista.setCPF("000000");
        correntista.setNome("Nome");

        when(dao.getCorrentistas()).thenReturn(Arrays.asList(correntista));
    }

    @Test
    public void correntistaDeveLogar() {
        caixa = dao.getCaixa();
        correntista = dao.getCorrentistas().get(0);
        caixa.logar(correntista);

        Assert.assertTrue(caixa.isLogado());

        verify(dao, times(1)).getCorrentistas();
    }

    @Test
    public void correntistaDeveEstarAtivo() {
        correntista = dao.getCorrentistas().get(0);
        Assert.assertTrue(correntista.getConta().getStatus());
    }

    @Test
    public void caixaAutomaticoECorrentistaDeveTerSaldoParaSacar() {
        caixa = dao.getCaixa();
        correntista = dao.getCorrentistas().get(0);
        double valorSaque = 100;
        Assert.assertTrue(caixa.podeSacar(valorSaque));
        Assert.assertTrue(correntista.getConta().podeSacar(valorSaque));
    }

    @Test
    public void todosProcessosParaSacar() {
        caixa = dao.getCaixa();
        correntista = dao.getCorrentistas().get(0);
        caixa.logar(correntista);

        Assert.assertTrue(caixa.isLogado());
        Assert.assertTrue(correntista.getConta().getStatus());
        
        double caixaSaldoComeco = caixa.getSaldo();
        double correntistaSaldoComeco = correntista.getConta().getSaldo();
        double valorSaque = 1000;
        Assert.assertTrue(caixa.podeSacar(valorSaque));
        Assert.assertTrue(correntista.getConta().podeSacar(valorSaque));
        
        caixa.sacar(valorSaque);
        Assert.assertEquals(caixaSaldoComeco - valorSaque, caixa.getSaldo(), 0);
        Assert.assertEquals(correntistaSaldoComeco - valorSaque, correntista.getConta().getSaldo(), 0);
    }

}

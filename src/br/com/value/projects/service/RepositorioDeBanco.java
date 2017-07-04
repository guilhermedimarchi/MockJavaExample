/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.value.projects.service;

import br.com.value.projects.dominio.CaixaAutomatico;
import br.com.value.projects.dominio.Correntista;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public interface RepositorioDeBanco {
    
    public CaixaAutomatico getCaixa();
    public List<Correntista> getCorrentistas();
    
    
}

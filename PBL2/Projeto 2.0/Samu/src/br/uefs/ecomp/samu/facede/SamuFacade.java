/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Componente Curricular: M�dulo Integrado de Programa��o Autor: <Washington Pagotto Batista>
 * Data: <23/05/2014>
 *
 * Declaro que este c�digo foi elaborado por mim de forma individual e n�o
 * cont�m nenhum trecho de c�digo de outro colega ou de outro autor, tais como
 * provindos de livros e apostilas, e p�ginas ou documentos eletr�nicos da
 * Internet. Qualquer trecho de c�digo de outra autoria que uma cita��o para o
 * n�o a minha est� destacado com autor e a fonte do c�digo, e estou ciente que
 * estes trechos n�o ser�o considerados para fins de avalia��o. Alguns trechos
 * do c�digo podem coincidir com de outros colegas pois estes foram discutidos
 * em sess�es tutorias.
 */

package br.uefs.ecomp.samu.facede;

import br.uefs.ecomp.samu.model.Ambulancia;
import br.uefs.ecomp.samu.model.Atendente;
import br.uefs.ecomp.samu.model.Cidadao;
import br.uefs.ecomp.samu.model.Ocorrencia;
import br.uefs.ecomp.samu.model.SamuController;
import br.uefs.ecomp.samu.model.exception.AmbulanciasInsifucienteException;
import br.uefs.ecomp.samu.model.exception.AtendenteIndisponivelException;
import br.uefs.ecomp.samu.model.exception.CadastroRepetidoException;
import br.uefs.ecomp.samu.model.exception.CapacidadeMaximaException;
import br.uefs.ecomp.samu.model.exception.CidadaoNaoEncontradoException;
import br.uefs.ecomp.samu.model.exception.OcorrenciaNaoEncontradaException;
import br.uefs.ecomp.samu.model.exception.QuantidadeDiferenteAmbulanciasException;
import br.uefs.ecomp.samu.util.Iterador;

/**
*
* @author Washington Pagotto Batista
*/

public class SamuFacade {

    private  SamuController controller;

    public SamuFacade() {
        controller = new SamuController();
    }

    public  Cidadao cadastrarCidadao(String cpf, String nome, String endereco) throws CadastroRepetidoException {
        return controller.cadastrarCidadao(cpf, nome, endereco);
    }

    public Iterador listarCidadaos() {
        return controller.listarCidadaos();
    }

    public double consultarDivida(String cpfCidadao) throws CidadaoNaoEncontradoException{
        return controller.consultarDivida(cpfCidadao);
    }

    public void pagarDivida(String cpfCidadao, double valor) throws CidadaoNaoEncontradoException {
        controller.pagarDivida(cpfCidadao, valor);
    }    
    
    public Atendente cadastrarAtendente(String cpf, String nome, String endereco, double salario) 
            throws CadastroRepetidoException, CapacidadeMaximaException{
        return controller.cadastrarAtendente(cpf, nome, endereco, salario);
    }

    public Iterador listarAtendentes() {
        return controller.listarAtendentes();
    }
    
    public Iterador listarAtendentesDisponiveis() {
        return controller.listarAtendentesDisponiveis();
    }

    public Ambulancia cadastrarAmbulancia(String placa) throws CadastroRepetidoException, CapacidadeMaximaException{
        return controller.cadastrarAmbulancia(placa);
    }

    public Iterador listarAmbulanciasDisponiveis() {
        return controller.listarAmbulanciasDisponiveis();
    }

    public Iterador listarAmbulancias() {
        return controller.listarAmbulancias();
    }

    public int cadastrarOcorrencia(String cpf, int qtdAmbulancias) 
            throws CidadaoNaoEncontradoException, AtendenteIndisponivelException{
        return controller.cadastrarOcorrencia(cpf, qtdAmbulancias);
    }

    public void atenderOcorrencia(int idOcorrencia) 
            throws OcorrenciaNaoEncontradaException, AmbulanciasInsifucienteException,
            QuantidadeDiferenteAmbulanciasException {
        
        controller.atenderOcorrencia(idOcorrencia);
    }

    public void finalizarOcorrencia(int idOcorrencia) throws OcorrenciaNaoEncontradaException {
        controller.finalizarOcorrencia(idOcorrencia);
    }

    public Iterador listarOcorrenciasAtivas() {
        return controller.listarOcorrenciasAtivas();
    }

    public Ocorrencia consultarOcorrencia(int idOcorrencia) throws OcorrenciaNaoEncontradaException{
        return controller.consultarOcorrencia(idOcorrencia);
    }
}
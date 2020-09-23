/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author bruno
 */
public class Fornecedor implements Observer {

    private int fornecedorId;
    private String nome;
    private int QtdVacinaEstoque;
    private List<String> Ocorrencia = new ArrayList<String>();

    public List<String> getOcorrencia() {
        return Ocorrencia;
    }

    public void setOcorrencia(List<String> Ocorrencia) {
        this.Ocorrencia = Ocorrencia;
    }

    public void setFornecedorId(int fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQtdVacinaEstoque(int QtdVacinaEstoque) {
        this.QtdVacinaEstoque = QtdVacinaEstoque;
    }

    public int getFornecedorId() {
        return fornecedorId;
    }

    public String getNome() {
        return nome;
    }

    public int getQtdVacinaEstoque() {
        return QtdVacinaEstoque;
    }

   
   @Override
    public void update(Observable o, Object o1) {
        PostoAtendimento postoAtendimento = (PostoAtendimento) o;
        String acao = String.valueOf(o1);
        if (acao.equals("Normal") && (postoAtendimento.getQuantidadeVacinas() - postoAtendimento.getLimiar() <= 20)) {
            Ocorrencia.add("Atenção! preparar reabastecimento do " + postoAtendimento.getNome() + ". Quantidade de Vacinas :" + postoAtendimento.getQuantidadeVacinas());
        } else if (acao.equals("Critico")) {
            Ocorrencia.add("Urgente reabastecer o " + postoAtendimento.getNome() + ". Quantidade de Vacinas: " + postoAtendimento.getQuantidadeVacinas());
        }else{
            Ocorrencia.add("O posto de atendimento" + postoAtendimento.getNome() + ".  Quantidade de Vacinas: " + postoAtendimento.getQuantidadeVacinas());
        }
    }
}

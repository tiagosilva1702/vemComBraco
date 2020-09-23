/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author bruno
 */
public class PostoAtendimento extends Observable{

    public void setPostoAtendimentoId(int postoAtendimentoId) {
        this.postoAtendimentoId = postoAtendimentoId;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidadeVacinas(int quantidadeVacinas) {
        this.quantidadeVacinas = quantidadeVacinas;
        mudaEstado();
    }

    public int getPostoAtendimentoId() {
        return postoAtendimentoId;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public String getNome() {
        return nome;
    }

    public int getLimiar() {
        return limiar;
    }

    public void setLimiar(int limiar) {
        this.limiar = limiar;
        mudaEstado();
    }

    public int getQuantidadeVacinas() {
        return quantidadeVacinas;
    }
    private int postoAtendimentoId;
    private List<Agendamento> agendamentos = new ArrayList<Agendamento>();
    private String nome;
    private int quantidadeVacinas;
    private int limiar;

    private void mudaEstado()
    {
        String acao;        
        if (this.limiar >= this.quantidadeVacinas) {
            acao = "Critico"; // NotificaObservadores
        }else{
            acao = "Normal";
        }
        setChanged(); // Mudou o estado
        notifyObservers(acao);
    }

    
}

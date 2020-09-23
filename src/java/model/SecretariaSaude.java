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
public class SecretariaSaude  implements Observer{

    public void setSecretariaSaudeId(int SecretariaSaudeId) {
        this.SecretariaSaudeId = SecretariaSaudeId;
    }

    public void setPostosAtendimentos(List<PostoAtendimento> postosAtendimentos) {
        this.postosAtendimentos = postosAtendimentos;
    }

    public void setSecretario(String secretario) {
        this.secretario = secretario;
    }

    public int getSecretariaSaudeId() {
        return SecretariaSaudeId;
    }

    public List<PostoAtendimento> getPostosAtendimentos() {
        return postosAtendimentos;
    }

    public String getSecretario() {
        return secretario;
    }
    private int SecretariaSaudeId;
    private List<PostoAtendimento> postosAtendimentos;
    private String secretario;
    private List<String> Ocorrencia = new ArrayList<String>();

    public void setOcorrencia(List<String> Ocorrencia) {
        this.Ocorrencia = Ocorrencia;
    }

    public List<String> getOcorrencia() {
        return Ocorrencia;
    }


    @Override
    public void update(Observable o, Object o1) {
        PostoAtendimento postoAtendimento = (PostoAtendimento)o;
        String acao = String.valueOf(o1);
        if (acao.equals("Normal")) {
            Ocorrencia.add("Quantidade Normal de vacina no posto " +postoAtendimento.getNome() + ". Quantitativo de : " + postoAtendimento.getQuantidadeVacinas());
        }else if(acao.equals("Critico")){
            Ocorrencia.add("Quantidade Critica de vacina no posto " +postoAtendimento.getNome() + ".Quantitativo de : " + postoAtendimento.getQuantidadeVacinas());
                }
    }
}

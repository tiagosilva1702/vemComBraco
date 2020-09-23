package model;


import java.util.Date;
import model.Usuario;


/**
 *
 * @author bruno
 */
public class Agendamento  {

    private int agendamentoI;
    private Date data;
    private boolean realizado;
    private Usuario usuario;

    public void setAgendamentoI(int agendamentoI) {
        this.agendamentoI = agendamentoI;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getAgendamentoI() {
        return agendamentoI;
    }

    public Date getData() {
        return data;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    
    
}

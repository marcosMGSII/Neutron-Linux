/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package neutron.capture.negocio;

/**
 *
 * @author Marcos
 */
public class erro {
    boolean Erro;
    String MensagemErro;
    String MensagemErroSistema;

    public boolean isErro() {
        return Erro;
    }

    public void setErro(boolean Erro) {
        this.Erro = Erro;
    }

    public String getMensagemErro() {
        return MensagemErro;
    }

    public void setMensagemErro(String MensagemErro) {
        this.MensagemErro = MensagemErro;
    }

    public String getMensagemErroSistema() {
        return MensagemErroSistema;
    }

    public void setMensagemErroSistema(String MensagemErroSistema) {
        this.MensagemErroSistema = MensagemErroSistema;
    }
    
}

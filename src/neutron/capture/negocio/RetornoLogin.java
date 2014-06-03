/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neutron.capture.negocio;

/**
 *
 * @author max
 */
public final class RetornoLogin {

    private String chaveAcesso;
    private String idUsuario;
    private String mensagem;

    public RetornoLogin() {
        this.chaveAcesso = "";
        this.idUsuario = "";
        this.mensagem = "";
    }

    public RetornoLogin(String chaveAcesso, String idUsuario, String mensagem) {
        this.chaveAcesso = chaveAcesso;
        this.idUsuario = idUsuario;
        this.mensagem = mensagem;
    }

    public String getChaveAcesso() {
        return chaveAcesso;
    }

    public void setChaveAcesso(String chaveAcesso) {
        this.chaveAcesso = chaveAcesso;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}

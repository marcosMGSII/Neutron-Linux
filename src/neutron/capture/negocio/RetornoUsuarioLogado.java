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
public class RetornoUsuarioLogado {
    int IDUsuario;
    String NomeUsuario;
    int IDOrganizacao;

    public int getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

    public String getNomeUsuario() {
        return NomeUsuario;
    }

    public void setNomeUsuario(String NomeUsuario) {
        this.NomeUsuario = NomeUsuario;
    }

    public int getIDOrganizacao() {
        return IDOrganizacao;
    }

    public void setIDOrganizacao(int IDOrganizacao) {
        this.IDOrganizacao = IDOrganizacao;
    }

    @Override
    public String toString() {
        return "RetornoUsuarioLogado{" + "IDUsuario=" + IDUsuario + ", NomeUsuario=" + NomeUsuario + ", IDOrganizacao=" + IDOrganizacao + '}';
    }
    
}

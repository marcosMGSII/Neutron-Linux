/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neutron.capture.negocio;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import neutron.capture.persistencia.DadosOFFLine;

/**
 *
 * @author Marcos Arruda
 */
public class Controle {

    private static Controle cp;

    RetornoNomeProcesso[] nomesProcessos;
    RetornoProcesso processo;
    RetornoProcesso_TipoDocumento tipoDocumentoSelecionado;
    String chaveAcesso;

    public RetornoProcesso_TipoDocumento getTipoDocumentoSelecionado() {
        return tipoDocumentoSelecionado;
    }

    public void setTipoDocumentoSelecionado(RetornoProcesso_TipoDocumento tipoDocumentoSelecionado) {
        this.tipoDocumentoSelecionado = tipoDocumentoSelecionado;
    }
    boolean offline;

    public RetornoProcesso getProcesso() {
        return processo;
    }

    public void setProcesso(RetornoProcesso processo) {
        this.processo = processo;
    }

    public String getChaveAcesso() {
        return chaveAcesso;
    }

    public void setChaveAcesso(String chaveAcesso) {
        this.chaveAcesso = chaveAcesso;
    }

    private Controle() {
        offline = false;
    }

    public boolean isOffline() {
        return offline;
    }

    public void setOffline(boolean offline) {
        this.offline = offline;
    }

    public final static Controle getInstacia() {
        if (Controle.cp == null) {
            Controle.cp = new Controle();
        }
        return Controle.cp;
    }

    public RetornoNomeProcesso[] getNomesProcessos() {
        return nomesProcessos;
    }

    public void setNomesProcessos(RetornoNomeProcesso[] rnp, String nomeUsuario) {
        this.nomesProcessos = rnp;
        DadosOFFLine dadosOFFLINE;
        try {
            dadosOFFLINE = new DadosOFFLine();
            dadosOFFLINE.salvaDadosListaProcessoOFFLine(rnp, nomeUsuario);
        } catch (ParserConfigurationException | NoSuchAlgorithmException | IOException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

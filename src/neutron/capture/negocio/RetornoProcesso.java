/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neutron.capture.negocio;

/**
 *
 * @author Marcos Arruda
 * @date 05/06/2014
 */
public class RetornoProcesso extends erro {

    @Override
    public String toString() {
        return "RetornoProcesso{" + "ID=" + ID + ", Nome=" + Nome + ", IDTipoDocumental=" + IDTipoDocumental + ", NomeTipoDocumental=" + NomeTipoDocumental + ", IDJanela=" + IDJanela + ", IDOrganizacao=" + IDOrganizacao + ", UsuarioLogado=" + UsuarioLogado + ", Campos=" + Campos + ", Campo_TipoDocumento=" + Campo_TipoDocumento + ", TiposDocumentos=" + TiposDocumentos + ", Agendado=" + Agendado + ", HoraAgendamento=" + HoraAgendamento + '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getIDTipoDocumental() {
        return IDTipoDocumental;
    }

    public void setIDTipoDocumental(int IDTipoDocumental) {
        this.IDTipoDocumental = IDTipoDocumental;
    }

    public String getNomeTipoDocumental() {
        return NomeTipoDocumental;
    }

    public void setNomeTipoDocumental(String NomeTipoDocumental) {
        this.NomeTipoDocumental = NomeTipoDocumental;
    }

    public int getIDJanela() {
        return IDJanela;
    }

    public void setIDJanela(int IDJanela) {
        this.IDJanela = IDJanela;
    }

    public int getIDOrganizacao() {
        return IDOrganizacao;
    }

    public void setIDOrganizacao(int IDOrganizacao) {
        this.IDOrganizacao = IDOrganizacao;        
    }

    public RetornoUsuarioLogado getUsuarioLogado() {
        return UsuarioLogado;
    }

    public void setUsuarioLogado(RetornoUsuarioLogado UsuarioLogado) {
        this.UsuarioLogado = UsuarioLogado;
    }

    public RetornoCampo[] getCampos() {
        return Campos;
    }

    public void setCampos(RetornoCampo[] Campos) {
        this.Campos = Campos;
    }

    public RetornoCampo getCampo_TipoDocumento() {
        return Campo_TipoDocumento;
    }

    public void setCampo_TipoDocumento(RetornoCampo Campo_TipoDocumento) {
        this.Campo_TipoDocumento = Campo_TipoDocumento;
    }

    public RetornoProcesso_TipoDocumento[] getTiposDocumentos() {
        return TiposDocumentos;
    }

    public void setTiposDocumentos(RetornoProcesso_TipoDocumento[] TiposDocumentos) {
        this.TiposDocumentos = TiposDocumentos;
    }

    public boolean isAgendado() {
        return Agendado;
    }

    public void setAgendado(boolean Agendado) {
        this.Agendado = Agendado;
    }

    public String getHoraAgendamento() {
        return HoraAgendamento;
    }

    public void setHoraAgendamento(String HoraAgendamento) {
        this.HoraAgendamento = HoraAgendamento;
    }

    int ID;
    String Nome;
    int IDTipoDocumental;
    String NomeTipoDocumental;
    int IDJanela;
    int IDOrganizacao;
    RetornoUsuarioLogado UsuarioLogado;
    RetornoCampo[] Campos;
    RetornoCampo Campo_TipoDocumento;
    RetornoProcesso_TipoDocumento[] TiposDocumentos;
    boolean Agendado;
    String HoraAgendamento;
}

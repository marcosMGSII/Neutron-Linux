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
public class RetornoCampo extends erro {

    int Casas_Decimais;
    boolean Unico;
    boolean Obrigatorio;
    int ID;
    String NOME;
    String APELIDO;
    RetornoTipoDado TIPO_DADO;
    int TAMANHO;
    int NUMERO_INTERNO;
    RetornoUsuarioLogado UsuarioLogado;

    public int getCasas_Decimais() {
        return Casas_Decimais;
    }

    public void setCasas_Decimais(int Casas_Decimais) {
        this.Casas_Decimais = Casas_Decimais;
    }

    public boolean isUnico() {
        return Unico;
    }

    public void setUnico(boolean Unico) {
        this.Unico = Unico;
    }

    public boolean isObrigatorio() {
        return Obrigatorio;
    }

    public void setObrigatorio(boolean Obrigatorio) {
        this.Obrigatorio = Obrigatorio;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getAPELIDO() {
        return APELIDO;
    }

    public void setAPELIDO(String APELIDO) {
        this.APELIDO = APELIDO;
    }

    public RetornoTipoDado getTIPO_DADO() {
        return TIPO_DADO;
    }

    public void setTIPO_DADO(RetornoTipoDado TIPO_DADO) {
        this.TIPO_DADO = TIPO_DADO;
    }

    public int getTAMANHO() {
        return TAMANHO;
    }

    public void setTAMANHO(int TAMANHO) {
        this.TAMANHO = TAMANHO;
    }

    public int getNUMERO_INTERNO() {
        return NUMERO_INTERNO;
    }

    public void setNUMERO_INTERNO(int NUMERO_INTERNO) {
        this.NUMERO_INTERNO = NUMERO_INTERNO;
    }

    public RetornoUsuarioLogado getUsuarioLogado() {
        return UsuarioLogado;
    }

    public void setUsuarioLogado(RetornoUsuarioLogado UsuarioLogado) {
        this.UsuarioLogado = UsuarioLogado;
    }

    @Override
    public String toString() {
        return "RetornoCampo{" + "Casas_Decimais=" + Casas_Decimais + ", Unico=" + Unico + ", Obrigatorio=" + Obrigatorio + ", ID=" + ID + ", NOME=" + NOME + ", APELIDO=" + APELIDO + ", TIPO_DADO=" + TIPO_DADO + ", TAMANHO=" + TAMANHO + ", NUMERO_INTERNO=" + NUMERO_INTERNO + ", UsuarioLogado=" + UsuarioLogado + '}';
    }

}

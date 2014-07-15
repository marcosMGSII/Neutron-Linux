/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neutron.capture.negocio;

/**
 *
 * @author Marcos Arruda
 */
public class RetornoProcesso_TipoDocumento extends Erro {

    int ID;
    int IDProcesso;
    String Nome;
    String PadraoCor;
    boolean Obrigatorio;
    int NumeroPaginas;
    int PaginasCapturadas;

    public int getPaginasCapturadas() {
        return PaginasCapturadas;
    }

    public void setPaginasCapturadas(int PaginasCapturadas) {
        this.PaginasCapturadas = PaginasCapturadas;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDProcesso() {
        return IDProcesso;
    }

    public void setIDProcesso(int IDProcesso) {
        this.IDProcesso = IDProcesso;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getPadraoCor() {
        return PadraoCor;
    }

    public void setPadraoCor(String PadraoCor) {
        this.PadraoCor = PadraoCor;
    }

    public boolean isObrigatorio() {
        return Obrigatorio;
    }

    public void setObrigatorio(boolean Obrigatorio) {
        this.Obrigatorio = Obrigatorio;
    }

    public int getNumeroPaginas() {
        return NumeroPaginas;
    }

    public void setNumeroPaginas(int NumeroPaginas) {
        this.NumeroPaginas = NumeroPaginas;
    }

}

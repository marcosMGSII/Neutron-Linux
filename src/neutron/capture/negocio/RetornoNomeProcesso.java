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
public class RetornoNomeProcesso {

    private String Nome;
    private int ID;

    public RetornoNomeProcesso(String Nome, int ID) {
        this.Nome = Nome;
        this.ID = ID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}

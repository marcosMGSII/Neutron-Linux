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
public class RetornoTipoDado {
    int ID;
    String TIPO;
    int DE;
    int ATE;
    String TIPO_DADOS_NO_BANCO;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    public int getDE() {
        return DE;
    }

    public void setDE(int DE) {
        this.DE = DE;
    }

    public int getATE() {
        return ATE;
    }

    public void setATE(int ATE) {
        this.ATE = ATE;
    }

    public String getTIPO_DADOS_NO_BANCO() {
        return TIPO_DADOS_NO_BANCO;
    }

    public void setTIPO_DADOS_NO_BANCO(String TIPO_DADOS_NO_BANCO) {
        this.TIPO_DADOS_NO_BANCO = TIPO_DADOS_NO_BANCO;
    }
    
    
}

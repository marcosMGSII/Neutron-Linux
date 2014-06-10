/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import javax.xml.parsers.ParserConfigurationException;
import neutron.capture.negocio.RetornoCampo;
import neutron.capture.negocio.RetornoNomeProcesso;
import neutron.capture.negocio.RetornoProcesso;
import neutron.capture.negocio.RetornoProcesso_TipoDocumento;
import neutron.capture.negocio.RetornoTipoDado;
import neutron.capture.persistencia.DadosOFFLine;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author max
 */
public class LoginOFFLineTESTES {

    public LoginOFFLineTESTES() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void salvaDadosLoginTESTE() throws ParserConfigurationException, NoSuchAlgorithmException, IOException {
        DadosOFFLine testeLoginOffLine = new DadosOFFLine();
        boolean retorno = testeLoginOffLine.salvaDadosLoginOFFLine("Neutron", "Kodak659", "MGS");
        assertEquals(true, retorno);
    }
    
    @Test
    public void validaDadosLoginTESTE() throws ParserConfigurationException, NoSuchAlgorithmException, IOException {
        DadosOFFLine testeLoginOffLine = new DadosOFFLine();
        boolean retorno = testeLoginOffLine.validaDadosLoginOFFLine("Usuário1", "Senha2", "Organização");
        assertEquals(true, retorno);
    }
    
    @Test
    public void salvaDadosNomeProcessosTeste() throws ParserConfigurationException, NoSuchAlgorithmException, IOException {
        DadosOFFLine testeLoginOffLine = new DadosOFFLine();
        RetornoNomeProcesso[] lsP = new RetornoNomeProcesso[2];
        lsP[0] = new RetornoNomeProcesso("Nome10", 10);
        lsP[1] = new RetornoNomeProcesso("Nome11", 11);
        boolean retorno = testeLoginOffLine.salvaDadosListaProcessoOFFLine(lsP, "Neutron");
        assertEquals(true, retorno);
    }
    
    @Test
    public void recuperaDadosNomeProcessosTeste() throws ParserConfigurationException, NoSuchAlgorithmException, IOException {
        DadosOFFLine testeLoginOffLine = new DadosOFFLine();
        RetornoNomeProcesso[] lsP = testeLoginOffLine.recuperaDadosListaProcessoOFFLine("Neutron");
        if (lsP != null) {
            for (RetornoNomeProcesso rt : lsP) {
                System.out.println("NOME: " + rt.getNome());
                System.out.println("ID: " + rt.getID());
            }
            assertEquals(2, lsP.length);
        } else {
            assertEquals(2, 0);
        }
    }
    
    @Test
    public void salvaDadosProcessoTeste() throws ParserConfigurationException, NoSuchAlgorithmException, IOException {
        DadosOFFLine testeLoginOffLine = new DadosOFFLine();
        RetornoProcesso p = new RetornoProcesso();
        p.setNome("Processo 1");
        p.setID(10);
        p.setIDTipoDocumental(1);
        p.setNomeTipoDocumental("Tipo Documental 1");
        p.setIDJanela(11);
        p.setIDOrganizacao(22);
        RetornoCampo[] camposTeste = new RetornoCampo[3];
        //Campo 1
        camposTeste[0] = new RetornoCampo();
        camposTeste[0].setCasas_Decimais(0);
        camposTeste[0].setUnico(true);
        camposTeste[0].setObrigatorio(true);
        camposTeste[0].setID(1);
        camposTeste[0].setNOME("CAMPO1");
        camposTeste[0].setAPELIDO("Campos 1");
        camposTeste[0].setNUMERO_INTERNO(1);
        camposTeste[0].setTAMANHO(10);
        RetornoTipoDado td = new RetornoTipoDado();
        td.setATE(0);
        td.setDE(0);
        td.setTIPO("Texto");
        td.setTIPO_DADOS_NO_BANCO("Varchar");
        camposTeste[0].setTIPO_DADO(td);
        //Campo 2
        camposTeste[1] = new RetornoCampo();
        camposTeste[1].setCasas_Decimais(2);
        camposTeste[1].setUnico(true);
        camposTeste[1].setObrigatorio(true);
        camposTeste[1].setID(1);
        camposTeste[1].setNOME("CAMPO2");
        camposTeste[1].setAPELIDO("Campos 2");
        camposTeste[1].setNUMERO_INTERNO(2);
        camposTeste[1].setTAMANHO(10);
        td = new RetornoTipoDado();
        td.setATE(10);
        td.setDE(0);
        td.setTIPO("Número");
        td.setTIPO_DADOS_NO_BANCO("Int");
        camposTeste[1].setTIPO_DADO(td);
        //Campo 2
        camposTeste[2] = new RetornoCampo();
        camposTeste[2].setCasas_Decimais(0);
        camposTeste[2].setUnico(false);
        camposTeste[2].setObrigatorio(false);
        camposTeste[2].setID(1);
        camposTeste[2].setNOME("CAMPO2");
        camposTeste[2].setAPELIDO("Campos 2");
        camposTeste[2].setNUMERO_INTERNO(3);
        camposTeste[2].setTAMANHO(0);
        td = new RetornoTipoDado();
        td.setATE(0);
        td.setDE(0);
        td.setTIPO("Data");
        td.setTIPO_DADOS_NO_BANCO("SmallDateTime");
        camposTeste[2].setTIPO_DADO(td);
        p.setCampos(camposTeste);
        RetornoProcesso_TipoDocumento[] tiposDocumentos = new RetornoProcesso_TipoDocumento[1];
        RetornoProcesso_TipoDocumento tempTD = new RetornoProcesso_TipoDocumento();
        tempTD.setID(1);
        tempTD.setIDProcesso(10);
        tempTD.setNome("RG");
        tempTD.setNumeroPaginas(2);
        tempTD.setObrigatorio(true);
        tempTD.setPadraoCor("Vermelho");
        tiposDocumentos[0] = tempTD;
        p.setTiposDocumentos(tiposDocumentos);
        assertEquals(true, testeLoginOffLine.salvaDadosProcessoOFFLine(p));
    }

    @Test
    public void recuperaDadosProcessoTeste() throws ParserConfigurationException, NoSuchAlgorithmException, IOException {
        DadosOFFLine testeLoginOffLine = new DadosOFFLine();
        RetornoProcesso p;
        p = testeLoginOffLine.recuperaDadosProcessoOFFLine("10");
        if (p != null)
            System.out.println(p.toString());
        assertEquals(true, p != null);
    }
}

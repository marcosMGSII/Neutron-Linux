/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neutron.capture.persistencia;

import com.google.gson.Gson;
import neutron.capture.negocio.RetornoLogin;
import neutron.capture.negocio.RetornoNomeProcesso;
import neutron.capture.negocio.RetornoProcesso;

/**
 *
 * @author Marcos Arruda
 */
public class acessoWebService {

    private boolean webSericeOnLine;
    private Proxy p;

    public boolean isWebSericeOnLine() {
        return webSericeOnLine;
    }

    public void setWebSericeOnLine(boolean webSericeOnLine) {
        this.webSericeOnLine = webSericeOnLine;
    }

    public acessoWebService() {        
        this.webSericeOnLine = false;
    }

    public RetornoLogin Login(String usuario, String senha, String organizacao, String idRede, Boolean administrador) {
        p = new Proxy();
        String q = "jsonLogin/" + usuario + "," + senha + "," + organizacao + "," + idRede + "," + administrador + "";
        String resultado = p.getResult(q);
        resultado = resultado.substring(19);
        resultado = resultado.substring(0, resultado.length() - 1);
        Gson gson = new Gson();
        RetornoLogin re = gson.fromJson(resultado, RetornoLogin.class);
        return re;
    }

    public void Teste() {
        try {
            p = new Proxy();
            String q = "jsonLogin/u,s,o,r,a";
            String resultado = this.p.getResult(q);
            resultado = resultado.substring(19);
            resultado = resultado.substring(0, resultado.length() - 1);
            Gson gson = new Gson();
            RetornoLogin re = gson.fromJson(resultado, RetornoLogin.class);
            webSericeOnLine = true;
        } catch (Exception e) {
            webSericeOnLine = false;
        }
    }

    public RetornoNomeProcesso[] ListaProcessos(String chaveAcesso) {
        p = new Proxy();
        String q = "LocalizarNomesProcessosJSON/" + chaveAcesso + "";
        String resultado = p.getResult(q);
        resultado = resultado.substring(37);
        resultado = resultado.substring(0, resultado.length() - 1);
        Gson gson = new Gson();
        RetornoNomeProcesso[] re = gson.fromJson(resultado, RetornoNomeProcesso[].class);
        return re;
    }

    public RetornoProcesso Processo(String idProcesso, String chaveAcesso) {
        p = new Proxy();
        String q = "LocalizarDadosProcessoJSON/" + idProcesso + "," + chaveAcesso + "";
        String resultado = p.getResult(q);
        resultado = resultado.substring(36);
        resultado = resultado.substring(0, resultado.length() - 1);
        Gson gson = new Gson();
        RetornoProcesso re = gson.fromJson(resultado, RetornoProcesso.class);
        return re;
    }
}

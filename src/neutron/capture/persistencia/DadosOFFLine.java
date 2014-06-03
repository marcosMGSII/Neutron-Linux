/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neutron.capture.persistencia;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import criptografia.Criptografia;
import java.awt.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.NoSuchPaddingException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import neutron.capture.negocio.RetornoCampo;
import neutron.capture.negocio.RetornoNomeProcesso;
import neutron.capture.negocio.RetornoProcesso;
import neutron.capture.negocio.RetornoTipoDado;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author max
 */
public class DadosOFFLine {

    DocumentBuilderFactory dbf;
    org.w3c.dom.Document doc;
    String nomeArquivoXML;

    public static void removeRecursively(Node node, short nodeType, String name) {
        if (node.getNodeType() == nodeType && (name == null || (node.getNodeName().equals(name)))) {
            node.getParentNode().removeChild(node);
        } else {
            // check the children recursively
            NodeList list = node.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                removeRecursively(list.item(i), nodeType, name);
            }
        }
    }

    private static Node localizaRecursivo(Node node, String textSearch) {
        if (textSearch != null) {
            if (node.getTextContent().toUpperCase().equals(textSearch.toUpperCase())) {
                return node;
            } else {
                // check the children recursively
                NodeList list = node.getChildNodes();
                for (int i = 0; i < list.getLength(); i++) {
                    localizaRecursivo(list.item(i), textSearch);
                }
            }
        }
        return null;
    }

    public DadosOFFLine() throws ParserConfigurationException {
        nomeArquivoXML = DadosOFFLine.class
                .getResource(File.separator + "resources" + File.separator + "xml" + File.separator + "loginOFFLogin.xml").getPath().replace("%20", " ");
        if (new File(nomeArquivoXML)
                .exists()) {
            dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbf.newDocumentBuilder();
            try {
                doc = docBuilder.parse(new File(nomeArquivoXML));
            } catch (SAXException | IOException ex) {
                Logger.getLogger(DadosOFFLine.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Arquivo: " + nomeArquivoXML + " não foi localizado.");
        }
    }

    public boolean salvaDadosLoginOFFLine(String nomeUsuario, String senhaUsuario, String organizacaoUsuario) throws NoSuchAlgorithmException, IOException {
        boolean retorno = true;
        try {
            if (nomeArquivoXML != null) {
                //Criptografa os dados antes de salvar            
                Criptografia criptografia = new Criptografia();
                Element rootTag = doc.getDocumentElement();
                Element loginsTag = (Element) rootTag.getElementsByTagName("logins").item(0);
                boolean loginAlterado = false;
                for (int i = 0; i < loginsTag.getChildNodes().getLength(); i++) {
                    Element loginTag = (Element) loginsTag.getElementsByTagName("login").item(i);
                    if (loginTag != null) {
                        Element nomeUsuarioTag = (Element) loginTag.getElementsByTagName("nomeUsuario").item(0);
                        if (criptografia.DecryptText(nomeUsuarioTag.getTextContent()).toUpperCase().equals(nomeUsuario.toUpperCase()) || nomeUsuarioTag.getTextContent().equals("")) {
                            //Usuário localizado atualiza os dados de login
                            nomeUsuarioTag.setTextContent(criptografia.EncryptText(nomeUsuario));
                            Element senhaUsuarioTag = (Element) loginTag.getElementsByTagName("senhaUsuario").item(0);
                            senhaUsuarioTag.setTextContent(criptografia.EncryptText(senhaUsuario));
                            Element organizacaoUsuarioTag = (Element) loginTag.getElementsByTagName("organizacaoUsuario").item(0);
                            organizacaoUsuarioTag.setTextContent(criptografia.EncryptText(organizacaoUsuario));
                            loginAlterado = true;
                        }
                    }
                }
                if (!loginAlterado) {
                    //Usuário não cadastrado criar usuário
                    Element novoLoginTag = doc.createElement("login");
                    Element novoUsuarioTag = doc.createElement("nomeUsuario");
                    novoUsuarioTag.setTextContent(criptografia.EncryptText(nomeUsuario));
                    novoLoginTag.appendChild(novoUsuarioTag);
                    Element novaSenhaTag = doc.createElement("senhaUsuario");
                    novaSenhaTag.setTextContent(criptografia.EncryptText(senhaUsuario));
                    novoLoginTag.appendChild(novaSenhaTag);
                    Element novaOrganizacaoTag = doc.createElement("organizacaoUsuario");
                    novaOrganizacaoTag.setTextContent(criptografia.EncryptText(organizacaoUsuario));
                    novoLoginTag.appendChild(novaOrganizacaoTag);
                    loginsTag.appendChild(novoLoginTag);
                }
                FileOutputStream teste = new FileOutputStream(nomeArquivoXML);
                XMLSerializer serializer = new XMLSerializer(teste, new OutputFormat(doc, "iso-8859-1", true));
                serializer.serialize(doc);
            }
        } catch (DOMException | NoSuchPaddingException | IOException e) {
            retorno = false;
        }
        return retorno;
    }

    public boolean validaDadosLoginOFFLine(String nomeUsuario, String senhaUsuario, String organizacaoUsuario) throws NoSuchAlgorithmException, IOException {
        boolean retorno = false;
        try {
            if (nomeArquivoXML != null) {
                //Criptografa os dados antes de salvar            
                Criptografia criptografia = new Criptografia();
                Element rootTag = doc.getDocumentElement();
                Element loginsTag = (Element) rootTag.getElementsByTagName("logins").item(0);
                for (int i = 0; i < loginsTag.getChildNodes().getLength(); i++) {
                    Element loginTag = (Element) loginsTag.getElementsByTagName("login").item(i);
                    if (loginTag != null) {
                        Element nomeUsuarioTag = (Element) loginTag.getElementsByTagName("nomeUsuario").item(0);
                        if (nomeUsuarioTag != null && criptografia.DecryptText(nomeUsuarioTag.getTextContent()).toUpperCase().equals(nomeUsuario.toUpperCase())) {
                            //Usuário localizado atualiza os dados de login                        
                            Element senhaUsuarioTag = (Element) loginTag.getElementsByTagName("senhaUsuario").item(0);
                            if (senhaUsuarioTag != null && criptografia.DecryptText(senhaUsuarioTag.getTextContent()).toUpperCase().equals(senhaUsuario.toUpperCase())) {
                                Element organizacaoUsuarioTag = (Element) loginTag.getElementsByTagName("organizacaoUsuario").item(0);
                                if (organizacaoUsuarioTag != null && criptografia.DecryptText(organizacaoUsuarioTag.getTextContent()).toUpperCase().equals(organizacaoUsuario.toUpperCase())) {
                                    retorno = true;
                                }
                            }
                        }
                    }
                }
            }
        } catch (DOMException e) {
            retorno = false;
        }
        return retorno;
    }

    public boolean salvaDadosListaProcessoOFFLine(RetornoNomeProcesso[] lsP, String nomeUsuario) throws NoSuchAlgorithmException, IOException {
        boolean retorno = true;
        try {
            if (nomeArquivoXML != null) {
                //Criptografa os dados antes de salvar            
                Criptografia criptografia = new Criptografia();
                Element rootTag = doc.getDocumentElement();
                Element listaprocessosTag = (Element) rootTag.getElementsByTagName("listaprocessos").item(0);
                if (listaprocessosTag != null) {
                    removeRecursively(doc, Node.ELEMENT_NODE, "nomeprocesso");
                    for (RetornoNomeProcesso processo : lsP) {
                        Element novoNomeProcessoTag = doc.createElement("nomeprocesso");
                        Element novoUsuarioTag = doc.createElement("nomeUsuario");
                        novoUsuarioTag.setTextContent(criptografia.EncryptText(nomeUsuario));
                        novoNomeProcessoTag.appendChild(novoUsuarioTag);
                        Element novoNomeTag = doc.createElement("nome");
                        novoNomeTag.setTextContent(criptografia.EncryptText(processo.getNome()));
                        novoNomeProcessoTag.appendChild(novoNomeTag);
                        Element novoIDTag = doc.createElement("id");
                        novoIDTag.setTextContent(criptografia.EncryptText(String.valueOf(processo.getID())));
                        novoNomeProcessoTag.appendChild(novoIDTag);
                        listaprocessosTag.appendChild(novoNomeProcessoTag);
                    }
                }
                FileOutputStream arquivoXMLSaida;
                arquivoXMLSaida = new FileOutputStream(nomeArquivoXML);
                XMLSerializer serializer = new XMLSerializer(arquivoXMLSaida, new OutputFormat(doc, "iso-8859-1", true));
                serializer.serialize(doc);
            }
        } catch (DOMException | NoSuchPaddingException | IOException e) {
            retorno = false;
        }
        return retorno;
    }

    public RetornoNomeProcesso[] recuperaDadosListaProcessoOFFLine(String nomeUsuario) throws NoSuchAlgorithmException, IOException {
        RetornoNomeProcesso[] retorno = null;
        LinkedList<RetornoNomeProcesso> r = new LinkedList<RetornoNomeProcesso>();
        try {
            if (nomeArquivoXML != null) {
                Criptografia criptografia = new Criptografia();
                Element rootTag = doc.getDocumentElement();
                Element listaprocessosTag = (Element) rootTag.getElementsByTagName("listaprocessos").item(0);
                if (listaprocessosTag != null && listaprocessosTag.getChildNodes().getLength() > 0) {
                    for (int i = 0; i < listaprocessosTag.getChildNodes().getLength(); i++) {
                        Element nomeprocessoTag = (Element) listaprocessosTag.getElementsByTagName("nomeprocesso").item(i);
                        if (nomeprocessoTag != null && criptografia.DecryptText(listaprocessosTag.getTextContent()).toUpperCase().equals(nomeUsuario.toUpperCase())) {
                            Element nomeUsuarioTag = (Element) nomeprocessoTag.getElementsByTagName("nomeUsuario").item(0);
                            if (nomeUsuarioTag != null && criptografia.DecryptText(nomeUsuarioTag.getTextContent()).toUpperCase().equals(nomeUsuario.toUpperCase())) {
                                Element nomeProcessoTag = (Element) nomeprocessoTag.getElementsByTagName("nome").item(0);
                                Element idProcessoTag = (Element) nomeprocessoTag.getElementsByTagName("id").item(0);
                                RetornoNomeProcesso aux = new RetornoNomeProcesso(criptografia.DecryptText(nomeProcessoTag.getTextContent()), Integer.parseInt(criptografia.DecryptText(idProcessoTag.getTextContent())));
                                r.add(aux);
                            }
                        }
                    }
                    if (r.size() > 0) {
                        retorno = new RetornoNomeProcesso[r.size()];
                        int ir = 0;
                        for (RetornoNomeProcesso rt : r) {
                            retorno[ir] = rt;
                            ir++;
                        }
                    }

                }
            }

        } catch (DOMException | NumberFormatException e) {
            retorno = null;
        }
        return retorno;
    }

    public RetornoProcesso recuperaDadosProcessoOFFLine(String idProcesso) throws NoSuchAlgorithmException, IOException {
        RetornoProcesso retorno = new RetornoProcesso();
        try {
            if (nomeArquivoXML != null) {
                Criptografia criptografia = new Criptografia();
                Element rootTag = doc.getDocumentElement();
                Element processosTag = (Element) rootTag.getElementsByTagName("processos").item(0);
                if (processosTag != null) {
                    for (int i = 0; i < processosTag.getChildNodes().getLength(); i++) {
                        Element processoTag = (Element) processosTag.getElementsByTagName("processo").item(i);
                        if (processoTag != null && "processo".equals(processoTag.getNodeName())) {
                            Element nomeprocessoTag = (Element) processoTag.getElementsByTagName("nomeprocesso").item(0);
                            retorno.setNome(criptografia.DecryptText(nomeprocessoTag.getTextContent()));
                            Element idprocessoTag = (Element) processoTag.getElementsByTagName("idprocesso").item(0);
                            retorno.setID(Integer.parseInt(criptografia.DecryptText(idprocessoTag.getTextContent())));
                            Element idtipodocumentalTag = (Element) processoTag.getElementsByTagName("idtipodocumental").item(0);
                            retorno.setIDTipoDocumental(Integer.parseInt(criptografia.DecryptText(idtipodocumentalTag.getTextContent())));
                            Element nometipodocumentalTag = (Element) processoTag.getElementsByTagName("nometipodocumental").item(0);
                            retorno.setNomeTipoDocumental(criptografia.DecryptText(nometipodocumentalTag.getTextContent()));
                            Element idjanelaTag = (Element) processoTag.getElementsByTagName("idjanela").item(0);
                            retorno.setIDJanela(Integer.parseInt(criptografia.DecryptText(idjanelaTag.getTextContent())));
                            Element idorganizacaoTag = (Element) processoTag.getElementsByTagName("idorganizacao").item(0);
                            retorno.setIDOrganizacao(Integer.parseInt(criptografia.DecryptText(idorganizacaoTag.getTextContent())));
                            Element camposTag = (Element) processoTag.getElementsByTagName("campos").item(0);
                            if (camposTag != null) {
                                ArrayList<RetornoCampo> campos = new ArrayList<>();
                                for (int j = 0; j < camposTag.getChildNodes().getLength() ; j++) {
                                    Element campoTag = (Element) camposTag.getElementsByTagName("campo").item(j);
                                    if (campoTag != null) {
                                        RetornoCampo campo = new RetornoCampo();
                                        Element casas_decimaisTag = (Element) campoTag.getElementsByTagName("casas_decimais").item(0);
                                        campo.setCasas_Decimais(Integer.parseInt(criptografia.DecryptText(casas_decimaisTag.getTextContent())));
                                        Element unicoTag = (Element) campoTag.getElementsByTagName("unico").item(0);
                                        campo.setUnico(Boolean.parseBoolean(criptografia.DecryptText(unicoTag.getTextContent())));
                                        Element obrigatorioTag = (Element) campoTag.getElementsByTagName("obrigatorio").item(0);
                                        campo.setObrigatorio(Boolean.parseBoolean(criptografia.DecryptText(obrigatorioTag.getTextContent())));
                                        Element idTag = (Element) campoTag.getElementsByTagName("id").item(0);
                                        campo.setID(Integer.parseInt(criptografia.DecryptText(idTag.getTextContent())));
                                        Element nomeTag = (Element) campoTag.getElementsByTagName("nome").item(0);
                                        campo.setNOME(criptografia.DecryptText(nomeTag.getTextContent()));
                                        Element apelidoTag = (Element) campoTag.getElementsByTagName("apelido").item(0);
                                        campo.setAPELIDO(criptografia.DecryptText(apelidoTag.getTextContent()));
                                        Element tamanhoTag = (Element) campoTag.getElementsByTagName("tamanho").item(0);
                                        campo.setTAMANHO(Integer.parseInt(criptografia.DecryptText(tamanhoTag.getTextContent())));
                                        Element numero_internoTag = (Element) campoTag.getElementsByTagName("numero_interno").item(0);
                                        campo.setNUMERO_INTERNO(Integer.parseInt(criptografia.DecryptText(numero_internoTag.getTextContent())));
                                        Element tipo_dadoTag = (Element) campoTag.getElementsByTagName("tipo_dado").item(0);
                                        if (tipo_dadoTag != null) {
                                            RetornoTipoDado tipoDado = new RetornoTipoDado();
                                            Element idtipo_dadoTag = (Element) tipo_dadoTag.getElementsByTagName("id").item(0);
                                            tipoDado.setID(Integer.parseInt(criptografia.DecryptText(idtipo_dadoTag.getTextContent())));
                                            Element tipoTag = (Element) tipo_dadoTag.getElementsByTagName("tipo").item(0);
                                            tipoDado.setTIPO(criptografia.DecryptText(tipoTag.getTextContent()));
                                            Element deTag = (Element) tipo_dadoTag.getElementsByTagName("de").item(0);
                                            tipoDado.setDE(Integer.parseInt(criptografia.DecryptText(deTag.getTextContent())));
                                            Element ateTag = (Element) tipo_dadoTag.getElementsByTagName("ate").item(0);
                                            tipoDado.setATE(Integer.parseInt(criptografia.DecryptText(ateTag.getTextContent())));
                                            Element tipo_dado_bancoTag = (Element) tipo_dadoTag.getElementsByTagName("tipo_dado_banco").item(0);
                                            tipoDado.setTIPO_DADOS_NO_BANCO(criptografia.DecryptText(tipo_dado_bancoTag.getTextContent()));
                                            campo.setTIPO_DADO(tipoDado);
                                        }
                                        campos.add(campo);
                                    }
                                }
                                RetornoCampo[] camposADD = new RetornoCampo[campos.size()]; 
                                int ir = 0;
                                for (RetornoCampo retornoCampo : campos) {
                                    camposADD[ir] = retornoCampo;
                                    ir ++;
                                }
                                retorno.setCampos(camposADD);
                            }
                        }
                    }
                }
            }
        } catch (DOMException | NumberFormatException e) {
            retorno = null;
        }
        return retorno;
    }

    private Element adicionaProcessoTAG(Element processoTag, RetornoProcesso p, boolean novo) throws UnsupportedEncodingException, NoSuchPaddingException {
        Criptografia criptografia = new Criptografia();
        Element nomeprocessoTag;
        if (!novo) {
            nomeprocessoTag = (Element) processoTag.getElementsByTagName("nomeprocesso").item(0);
        } else {
            nomeprocessoTag = (Element) doc.createElement("nomeprocesso");
            processoTag.appendChild(nomeprocessoTag);
        }
        nomeprocessoTag.setTextContent(criptografia.EncryptText(p.getNome()));

        Element idprocessoTag;
        if (!novo) {
            idprocessoTag = (Element) processoTag.getElementsByTagName("idprocesso").item(0);
        } else {
            idprocessoTag = (Element) doc.createElement("idprocesso");
            processoTag.appendChild(idprocessoTag);
        }
        idprocessoTag.setTextContent(criptografia.EncryptText(String.valueOf(p.getID())));

        Element idtipodocumentalTag;
        if (!novo) {
            idtipodocumentalTag = (Element) processoTag.getElementsByTagName("idtipodocumental").item(0);
        } else {
            idtipodocumentalTag = (Element) doc.createElement("idtipodocumental");
            processoTag.appendChild(idtipodocumentalTag);
        }
        idtipodocumentalTag.setTextContent(criptografia.EncryptText(String.valueOf(p.getIDTipoDocumental())));

        Element nometipodocumentalTag;
        if (!novo) {
            nometipodocumentalTag = (Element) processoTag.getElementsByTagName("nometipodocumental").item(0);
        } else {
            nometipodocumentalTag = (Element) doc.createElement("nometipodocumental");
            processoTag.appendChild(nometipodocumentalTag);
        }
        nometipodocumentalTag.setTextContent(criptografia.EncryptText(p.getNomeTipoDocumental()));

        Element idjanelaTag;
        if (!novo) {
            idjanelaTag = (Element) processoTag.getElementsByTagName("idjanela").item(0);
        } else {
            idjanelaTag = (Element) doc.createElement("idjanela");
            processoTag.appendChild(idjanelaTag);
        }
        idjanelaTag.setTextContent(criptografia.EncryptText(String.valueOf(p.getIDJanela())));

        Element idorganizacaoTag;
        if (!novo) {
            idorganizacaoTag = (Element) processoTag.getElementsByTagName("idorganizacao").item(0);
        } else {
            idorganizacaoTag = (Element) doc.createElement("idorganizacao");
            processoTag.appendChild(idorganizacaoTag);
        }
        idorganizacaoTag.setTextContent(criptografia.EncryptText(String.valueOf(p.getIDOrganizacao())));

        Element camposTag;
        if (!novo) {
            camposTag = (Element) processoTag.getElementsByTagName("campos").item(0);
        } else {
            camposTag = (Element) doc.createElement("campos");
        }
        if (camposTag != null) {
            removeRecursively(camposTag, Node.ELEMENT_NODE, "campo");
            for (RetornoCampo campo : p.getCampos()) {
                Element campoTag = (Element) doc.createElement("campo");

                Element casas_decimaisTag = (Element) doc.createElement("casas_decimais");
                casas_decimaisTag.setTextContent(criptografia.EncryptText(String.valueOf(campo.getCasas_Decimais())));
                campoTag.appendChild(casas_decimaisTag);

                Element unicoTag = (Element) doc.createElement("unico");
                unicoTag.setTextContent(criptografia.EncryptText(String.valueOf(campo.isUnico())));
                campoTag.appendChild(unicoTag);

                Element obrigatorioTag = (Element) doc.createElement("obrigatorio");
                obrigatorioTag.setTextContent(criptografia.EncryptText(String.valueOf(campo.isObrigatorio())));
                campoTag.appendChild(obrigatorioTag);

                Element idTag = (Element) doc.createElement("id");
                idTag.setTextContent(criptografia.EncryptText(String.valueOf(campo.getID())));
                campoTag.appendChild(idTag);

                Element nomeTag = (Element) doc.createElement("nome");
                nomeTag.setTextContent(criptografia.EncryptText(campo.getNOME()));
                campoTag.appendChild(nomeTag);

                Element apelidoTag = (Element) doc.createElement("apelido");
                apelidoTag.setTextContent(criptografia.EncryptText(campo.getAPELIDO()));
                campoTag.appendChild(apelidoTag);

                Element tamanhoTag = (Element) doc.createElement("tamanho");
                tamanhoTag.setTextContent(criptografia.EncryptText(String.valueOf(campo.getTAMANHO())));
                campoTag.appendChild(tamanhoTag);

                Element numero_internoTag = (Element) doc.createElement("numero_interno");
                numero_internoTag.setTextContent(criptografia.EncryptText(String.valueOf(campo.getNUMERO_INTERNO())));
                campoTag.appendChild(numero_internoTag);

                Element tipo_dadoTag = (Element) doc.createElement("tipo_dado");

                Element idtipo_dadoTag = (Element) doc.createElement("id");
                idtipo_dadoTag.setTextContent(criptografia.EncryptText(String.valueOf(campo.getTIPO_DADO().getID())));
                tipo_dadoTag.appendChild(idtipo_dadoTag);

                Element tipoTag = (Element) doc.createElement("tipo");
                tipoTag.setTextContent(criptografia.EncryptText(campo.getTIPO_DADO().getTIPO()));
                tipo_dadoTag.appendChild(tipoTag);

                Element deTag = (Element) doc.createElement("de");
                deTag.setTextContent(criptografia.EncryptText(String.valueOf(campo.getTIPO_DADO().getDE())));
                tipo_dadoTag.appendChild(deTag);

                Element ateTag = (Element) doc.createElement("ate");
                ateTag.setTextContent(criptografia.EncryptText(String.valueOf(campo.getTIPO_DADO().getATE())));
                tipo_dadoTag.appendChild(ateTag);

                Element tipo_dado_bancoTag = (Element) doc.createElement("tipo_dado_banco");
                tipo_dado_bancoTag.setTextContent(criptografia.EncryptText(campo.getTIPO_DADO().getTIPO_DADOS_NO_BANCO()));
                tipo_dadoTag.appendChild(tipo_dado_bancoTag);

                campoTag.appendChild(tipo_dadoTag);

                camposTag.appendChild(campoTag);
            }
            processoTag.appendChild(camposTag);
        }
        return processoTag;
    }

    @SuppressWarnings("UnusedAssignment")
    public boolean salvaDadosProcessoOFFLine(RetornoProcesso p) throws NoSuchAlgorithmException, IOException, UnsupportedEncodingException {
        boolean retorno = true;
        try {
            if (nomeArquivoXML != null) {
                Element rootTag = doc.getDocumentElement();
                Element processosTag = (Element) rootTag.getElementsByTagName("processos").item(0);
                boolean achouProcesso = false;
                if (processosTag != null) {
                    Criptografia criptografia = new Criptografia();
                    for (int i = 0; i < processosTag.getChildNodes().getLength(); i++) {
                        Element processoTag = (Element) processosTag.getElementsByTagName("processo").item(i);
                        if (!achouProcesso && processoTag != null) {
                            Node idProcessoTag = processoTag.getElementsByTagName("idprocesso").item(0);
                            if (idProcessoTag != null) {
                                if (criptografia.DecryptText(idProcessoTag.getTextContent()).equals(String.valueOf(p.getID()))) {
                                    achouProcesso = true;
                                    processoTag = adicionaProcessoTAG(processoTag, p, false);
                                }
                            }
                        }
                    }
                }
                if (!achouProcesso) {
                    //Novo processo
                    Element processoTag = adicionaProcessoTAG((Element) doc.createElement("processo"), p, true);
                    processosTag.appendChild(processoTag);
                }
            }
            FileOutputStream arquivoXMLSaida;
            arquivoXMLSaida = new FileOutputStream(nomeArquivoXML);
            XMLSerializer serializer = new XMLSerializer(arquivoXMLSaida, new OutputFormat(doc, "iso-8859-1", true));
            serializer.serialize(doc);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(DadosOFFLine.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return retorno;
    }

}

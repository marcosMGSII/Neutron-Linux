/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neutron.capture.apresentacao;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import neutron.capture.negocio.Controle;
import neutron.capture.negocio.JPanelWithBackground;
import neutron.capture.negocio.RetornoLogin;
import neutron.capture.persistencia.acessoWebService;
import neutron.capture.persistencia.DadosOFFLine;

/**
 *
 * @author Marcos Arruda
 */
public class LoginFrame extends javax.swing.JFrame {

    JPanelWithBackground background = null;

    public LoginFrame() {
        super.setSize(656, 350);
        super.setResizable(false);
        super.setTitle("Neutron Capture - Entrar no Sistema");
        super.setLocationRelativeTo(null); // para ficar centralizada
        super.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // o caminho da imagem é passado na instância do objeto:
        // lembre-se de passar o caminho da sua imagem no disco, porque, caso contrário,
        // vai dar erro na execução
        background = new JPanelWithBackground(Splash.class.getResource(File.separator + "resources" + File.separator + "Imagens" + File.separator + "Login.jpg").getPath().replace("%20", " "));
        getContentPane().add(background);
        background.setSize(656, 356);
        inicializaComponents(background);
    }

    private void definiIcone() {
        // coloca uma figura na barra de título da janela
        String sep = File.separator;
        StringBuilder s = new StringBuilder();
        s.append(sep);
        s.append("resources");
        s.append(sep);
        s.append("imagens");
        s.append(sep);
        s.append("icones");
        s.append(sep);
        s.append("Neutron_Capture.png");
        URL url = getClass().getResource(s.toString());
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
    }

    private void inicializaComponents(JPanelWithBackground b) {
        txtUsuario = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        lblOrganizacao = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        lblSenha = new javax.swing.JLabel();
        txtOrganizacao = new javax.swing.JTextField();
        btnEntrar = new javax.swing.JButton();
        chcOffLine = new javax.swing.JCheckBox();

        b.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        b.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 42, 300, -1));

        lblUsuario.setText("Usuario:");
        b.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 18, -1, -1));

        lblOrganizacao.setText("Organizacao:");
        b.add(lblOrganizacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 140, -1, -1));

        b.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 100, 300, -1));

        lblSenha.setText("Senha:");
        b.add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 76, -1, -1));
        b.add(txtOrganizacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 164, 300, -1));

        chcOffLine.setText("Entrar offline");
        b.add(chcOffLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 247, -1, -1));

        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CliqueEntrar(evt);
            }
        });
        b.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 240, -1, -1));
        txtUsuario.setText("Neutron");
        txtSenha.setText("Kodak659");
        txtOrganizacao.setText("MGS");
        this.definiIcone();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panLogin = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        lblOrganizacao = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        lblSenha = new javax.swing.JLabel();
        txtOrganizacao = new javax.swing.JTextField();
        btnEntrar = new javax.swing.JButton();
        chcOffLine = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.SystemColor.control);
        setIconImage(getIconImage());
        setIconImages(null);
        setResizable(false);

        panLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuario.setText("MARCOS");
        panLogin.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 42, 248, -1));

        lblUsuario.setText("Usuario:");
        panLogin.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 18, -1, -1));

        lblOrganizacao.setText("Organizacao:");
        panLogin.add(lblOrganizacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 140, -1, -1));

        txtSenha.setText("141182");
        panLogin.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 100, 248, -1));

        lblSenha.setText("Senha:");
        panLogin.add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 76, -1, -1));

        txtOrganizacao.setText("MGS Imagem e Informacao LTDA");
        panLogin.add(txtOrganizacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 164, 248, -1));

        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CliqueEntrar(evt);
            }
        });
        panLogin.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 204, -1, -1));

        chcOffLine.setText("Entrar offline");
        panLogin.add(chcOffLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(panLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(198, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CliqueEntrar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CliqueEntrar
        Boolean camposOK = true;
        if (txtUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo usuario!");
            camposOK = false;
        }
        if (camposOK && txtSenha.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo senha!");
            camposOK = false;
        }
        if (camposOK && txtOrganizacao.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo organizacao!");
            camposOK = false;
        }
        if (camposOK) {
            String nomeUsuarioLogado;
            nomeUsuarioLogado = txtUsuario.getText();
            if (!chcOffLine.isSelected()) {
                acessoWebService servico = new acessoWebService();
                servico.Teste();
                if (!servico.isWebSericeOnLine()) {
                    JOptionPane.showMessageDialog(null, "Falha ao realizar conexão com o servidor.\nTente entrar em modo offline!", "Servidor Offline", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    RetornoLogin r;
                    r = servico.Login("Marcos", "141182", "MGS Imagem e Informação LTDA", "MGSIIMARCOS", Boolean.valueOf("false"));
                    nomeUsuarioLogado = "Marcos";
                    if (r.getChaveAcesso().equals("")) {
                        JOptionPane.showMessageDialog(null, r.getMensagem(), "Dados inválidos", JOptionPane.WARNING_MESSAGE);
                    } else {
                        //Login realizado
                        Controle cp = Controle.getInstacia();
                        cp.setOffline(false);
                        cp.setChaveAcesso(r.getChaveAcesso());
                        cp.setNomesProcessos(servico.ListaProcessos(r.getChaveAcesso()), nomeUsuarioLogado);

                        JFrame selecionaProcesso = new SelecionaProcessoFrame();
                        selecionaProcesso.getContentPane().setBackground(Color.white);
                        selecionaProcesso.setVisible(true);
                        this.dispose();
                    }
                }
            } else {
                try {
                    DadosOFFLine loginOFF = new DadosOFFLine();
                    if (loginOFF.validaDadosLoginOFFLine(this.txtUsuario.getText(), this.txtSenha.getText(), this.txtOrganizacao.getText())) {
                        Controle cp = Controle.getInstacia();
                        cp.setOffline(true);
                        cp.setNomesProcessos(loginOFF.recuperaDadosListaProcessoOFFLine(this.txtUsuario.getText()), this.txtUsuario.getText());
                        JFrame selecionaProcesso = new SelecionaProcessoFrame();
                        selecionaProcesso.getContentPane().setBackground(Color.white);
                        selecionaProcesso.setVisible(true);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário ou senha inválido.", "Dados inválidos", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (ParserConfigurationException | NoSuchAlgorithmException | IOException ex) {
                    Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_CliqueEntrar

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JCheckBox chcOffLine;
    private javax.swing.JLabel lblOrganizacao;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel panLogin;
    private javax.swing.JTextField txtOrganizacao;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}

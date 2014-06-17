/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neutron.capture.apresentacao;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.xml.parsers.ParserConfigurationException;
import neutron.capture.negocio.Controle;
import neutron.capture.negocio.RetornoNomeProcesso;
import neutron.capture.negocio.RetornoProcesso;
import neutron.capture.persistencia.DadosOFFLine;
import neutron.capture.persistencia.acessoWebService;

/**
 *
 * @author max
 */
public class SelecionaProcessoFrame extends javax.swing.JFrame {

    private int numProcessos;
    private JPanel panProcessos;
    private JPanel panProcessos2;

    public SelecionaProcessoFrame() {
        initComponents();
        numProcessos = 1;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.WHITE);

        panProcessos = new JPanel();
        panProcessos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panProcessos.setSize(191, 70);
        panProcessoColuna1.setViewportView(panProcessos);
        panProcessos.setBackground(Color.WHITE);
        panProcessoColuna1.setBackground(Color.WHITE);

        panProcessos2 = new JPanel();
        panProcessos2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panProcessos2.setSize(191, 70);
        panProcessoColuna2.setViewportView(panProcessos2);
        panProcessos2.setBackground(Color.WHITE);
        panProcessoColuna2.setBackground(Color.WHITE);
        Controle cp = Controle.getInstacia();
        adicionaProcesos(cp.getNomesProcessos());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogo = new javax.swing.JLabel();
        panProcessoColuna1 = new javax.swing.JScrollPane();
        panProcessoColuna2 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(150, 89, 28));
        setForeground(new java.awt.Color(245, 220, 28));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Imagens/Logo.jpg"))); // NOI18N
        lblLogo.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        panProcessoColuna1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        panProcessoColuna2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Imagens/logo_neutron.png"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(88, 119, 173));
        lblTitulo.setText("Selecione um processo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(panProcessoColuna1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(panProcessoColuna2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lblLogo)
                .addGap(45, 45, 45)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panProcessoColuna1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(panProcessoColuna2))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adicionaProcesos(RetornoNomeProcesso[] rp) {
        if (rp != null) {
            for (RetornoNomeProcesso umProcesso : rp) {
                addBotaoProcesso(umProcesso);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuário não possui processos vinculados.", "Processos", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void addBotaoProcesso(RetornoNomeProcesso p) {
        JButton botaoProcesso = new JButton();
        botaoProcesso.setName("btnP" + p.getID());
        botaoProcesso.setFont(new java.awt.Font("SansSerif", 1, 15));
        botaoProcesso.setForeground(new java.awt.Color(88, 119, 173));
        botaoProcesso.setText(p.getNome());
        botaoProcesso.setHorizontalTextPosition(SwingConstants.CENTER);

        //Objeto para concatenar o caminho dos icones
        String sep = File.separator;
        StringBuilder s = new StringBuilder();
        s.append(sep);
        s.append("resources");
        s.append(sep);
        s.append("imagens");
        s.append(sep);
        s.append("botoes");
        s.append(sep);

        s.append("botao_processo.png");
        botaoProcesso.setIcon(new ImageIcon(getClass().getResource(s.toString())));
        s.delete(s.length() - 18, s.length());
        s.append("botao_processo_sel.png");
        botaoProcesso.setRolloverIcon(new ImageIcon(getClass().getResource(s.toString())));
        botaoProcesso.setSize(184, 54);
        botaoProcesso.setLocation(0, (numProcessos - 1) * 70);
        botaoProcesso.setToolTipText(botaoProcesso.getText());

        botaoProcesso.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    processoButtonsActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(SelecionaProcessoFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        botaoProcesso.setBorder(null);
        botaoProcesso.setContentAreaFilled(false);
        if (numProcessos > 10) {
            panProcessos2.add(botaoProcesso, new org.netbeans.lib.awtextra.AbsoluteConstraints(botaoProcesso.getX(), (numProcessos - 11) * 70, -1, -1));
            panProcessos2.setSize(190 * numProcessos, 70);
            numProcessos++;
            panProcessos2.repaint();
            panProcessoColuna2.repaint();
            panProcessoColuna2.revalidate();
        } else {

            panProcessos.add(botaoProcesso, new org.netbeans.lib.awtextra.AbsoluteConstraints(botaoProcesso.getX(), botaoProcesso.getY(), -1, -1));
            panProcessos.setSize(190 * numProcessos, 70);
            numProcessos++;
            panProcessos.repaint();
            panProcessoColuna1.repaint();
            panProcessoColuna1.revalidate();
        }
    }

    private void processoButtonsActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        JButton bt = (JButton) evt.getSource();        
        String idProcesso = bt.getName().substring(4);        
        Controle cp = Controle.getInstacia();
        RetornoProcesso p = null;
        if (!cp.isOffline()) {
            acessoWebService servico = new acessoWebService();
            p = servico.Processo(idProcesso, cp.getChaveAcesso());
        } else {
            DadosOFFLine getProcessoOffLine;
            try {
                getProcessoOffLine = new DadosOFFLine();
                p = getProcessoOffLine.recuperaDadosProcessoOFFLine("" + idProcesso);
            } catch (ParserConfigurationException | NoSuchAlgorithmException ex) {
                Logger.getLogger(SelecionaProcessoFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (p != null) {
            cp.setProcesso(p);
            if (!cp.isOffline()) {
                DadosOFFLine setProcessoOffLine;
                try {
                    setProcessoOffLine = new DadosOFFLine();
                    setProcessoOffLine.salvaDadosProcessoOFFLine(p);
                } catch (        ParserConfigurationException | NoSuchAlgorithmException | UnsupportedEncodingException ex) {
                    Logger.getLogger(SelecionaProcessoFrame.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }
        } else {
            //Falha ao buscar dados do processo
        }
        SelecionaTipoDocumento st = new SelecionaTipoDocumento();
        st.setVisible(true);
        this.dispose();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane panProcessoColuna1;
    private javax.swing.JScrollPane panProcessoColuna2;
    // End of variables declaration//GEN-END:variables
}

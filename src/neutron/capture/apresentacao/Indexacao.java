/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neutron.capture.apresentacao;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import neutron.capture.negocio.Controle;
import neutron.capture.negocio.IntegerDocument;
import neutron.capture.negocio.RetornoCampo;
import neutron.capture.negocio.RetornoProcesso;

/**
 *
 * @author max
 */
public class Indexacao extends javax.swing.JFrame {

    /**
     * Creates new form Indexacao
     */
    public Indexacao() {
        initComponents();
        addCampos();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.WHITE);
        panCampos.setBackground(Color.WHITE);
        btnConcluir.setBorder(null);
        btnConcluir.setContentAreaFilled(false);
    }

    private void initComponentsManual() {

    }

    private void addCampos() {
        try {
            Controle cp = Controle.getInstacia();
            if (cp.getProcesso() != null) {
                RetornoProcesso rp = cp.getProcesso();
                panCampos.removeAll();
                int posicaoCampo = -30;
                for (RetornoCampo campoProcesso : rp.getCampos()) {
                    posicaoCampo += 30;
                    javax.swing.JLabel lblCampo = new javax.swing.JLabel();
                    lblCampo.setBounds(0, 0, 300, 20);
                    lblCampo.setFont(new java.awt.Font("SansSerif", 1, 13));
                    lblCampo.setText(campoProcesso.getAPELIDO());
                    lblCampo.setName("lbl" + campoProcesso.getNOME());
                    lblCampo.setLocation(0, posicaoCampo);
                    panCampos.add(lblCampo);
                    posicaoCampo += 23;
                    javax.swing.JFormattedTextField txtCampo = new javax.swing.JFormattedTextField();
                    txtCampo.setFont(new java.awt.Font("SansSerif", 0, 12));
                    txtCampo.setBounds(0, 0, 500, 30);
                    txtCampo.setName("txt" + campoProcesso.getNOME());
                    txtCampo.setLocation(0, posicaoCampo);
                    switch (campoProcesso.getTIPO_DADO().getTIPO()) {
                        case "Número":
                            txtCampo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
                            txtCampo.setDocument(new IntegerDocument(15));
                            break;
                        case "Data":
                            txtCampo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));                            
                            break;
                        default:
                            txtCampo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DefaultFormatter()));
                   }
                    panCampos.add(txtCampo);
                }
                panCampos.revalidate();
                panCampos.repaint();
            }
        } catch (Exception e) {
            Logger.getLogger(Indexacao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogoMMGS = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblLogoNeutron = new javax.swing.JLabel();
        panCampos = new javax.swing.JPanel();
        btnConcluir = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLogoMMGS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Imagens/Logo.jpg"))); // NOI18N
        lblLogoMMGS.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblTitulo.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(88, 119, 173));
        lblTitulo.setText("Realize a indexação");

        lblLogoNeutron.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Imagens/logo_neutron.png"))); // NOI18N

        panCampos.setBackground(new java.awt.Color(199, 159, 22));

        javax.swing.GroupLayout panCamposLayout = new javax.swing.GroupLayout(panCampos);
        panCampos.setLayout(panCamposLayout);
        panCamposLayout.setHorizontalGroup(
            panCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panCamposLayout.setVerticalGroup(
            panCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        btnConcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/botoes/botao_processo_concluido.png"))); // NOI18N
        btnConcluir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/botoes/processo_concluido_sel.png"))); // NOI18N
        btnConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcluirActionPerformed(evt);
            }
        });

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblLogoMMGS)
                                .addGap(45, 45, 45)
                                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(panCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLogoNeutron)
                    .addComponent(btnConcluir))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblLogoMMGS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLogoNeutron)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(panCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConcluir)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcluirActionPerformed
        // TODO add your handling code here:
        addCampos();
    }//GEN-LAST:event_btnConcluirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Indexacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Indexacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Indexacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Indexacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Indexacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConcluir;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel lblLogoMMGS;
    private javax.swing.JLabel lblLogoNeutron;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panCampos;
    // End of variables declaration//GEN-END:variables
}

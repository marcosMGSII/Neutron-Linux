/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neutron.capture.apresentacao;

import java.awt.Color;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import neutron.capture.negocio.Controle;
import neutron.capture.negocio.RetornoProcesso;
import neutron.capture.negocio.RetornoProcesso_TipoDocumento;

/**
 *
 * @author max
 */
public class SelecionaTipoDocumento extends javax.swing.JFrame {

    private int numProcessos;
    private JPanel panProcessos;
    private JPanel panProcessos2;

    public SelecionaTipoDocumento() {
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
        AddBotoes(cp.getProcesso());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panProcessoColuna1 = new javax.swing.JScrollPane();
        panProcessoColuna2 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(150, 89, 28));
        setForeground(new java.awt.Color(245, 220, 28));

        panProcessoColuna1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        panProcessoColuna2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Imagens/logo_neutron.png"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(88, 119, 173));
        lblTitulo.setText("Selecione um Tipo de Documento");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Imagens/Logo.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panProcessoColuna1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panProcessoColuna2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panProcessoColuna1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                    .addComponent(panProcessoColuna2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddBotoes(RetornoProcesso rp) {
        if (rp != null) {
            for (RetornoProcesso_TipoDocumento umTipo : rp.getTiposDocumentos()) {
                addBotaoProcesso(umTipo);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Nenhum tipo de tocumento localizado.\nO processo não possui tipos de documentos cadastrados!", "Tipo de Documentos", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void addBotaoProcesso(RetornoProcesso_TipoDocumento td) {
        JButton botaoProcesso = new JButton();
        botaoProcesso.setName("btnT" + td.getID());
        botaoProcesso.setFont(new java.awt.Font("SansSerif", 1, 15));
        botaoProcesso.setForeground(new java.awt.Color(88, 119, 173));
        if (td.getNome().length() > 17) {
            botaoProcesso.setText(td.getNome().substring(0, 15) + "...");
        } else {
            botaoProcesso.setText(td.getNome());
        }

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

        if (td.isObrigatorio()) {
            s.append("botao_processo_obrigatorio.png");
            botaoProcesso.setIcon(new ImageIcon(getClass().getResource(s.toString())));
            s.delete(s.length() - 30, s.length());
            s.append("botao_processo_obrigatorio_sel.png");
            botaoProcesso.setRolloverIcon(new ImageIcon(getClass().getResource(s.toString())));
            botaoProcesso.setSize(184, 54);
            botaoProcesso.setLocation(0, (numProcessos - 1) * 61);
            botaoProcesso.setToolTipText(td.getNome() + " - Processo Obrigatório!");
        } else {
            s.append("botao_processo.png");
            botaoProcesso.setIcon(new ImageIcon(getClass().getResource(s.toString())));
            s.delete(s.length() - 18, s.length());
            s.append("botao_processo_sel.png");
            botaoProcesso.setRolloverIcon(new ImageIcon(getClass().getResource(s.toString())));
            botaoProcesso.setSize(184, 54);
            botaoProcesso.setLocation(0, (numProcessos - 1) * 61);
            botaoProcesso.setToolTipText(botaoProcesso.getText());
        }

        botaoProcesso.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processoButtonsActionPerformed(evt);
            }
        });
        botaoProcesso.setBorder(null);
        if (numProcessos > 10) {
            panProcessos2.add(botaoProcesso, new org.netbeans.lib.awtextra.AbsoluteConstraints(botaoProcesso.getX(), (numProcessos - 11) * 61, -1, -1));
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

    private void processoButtonsActionPerformed(java.awt.event.ActionEvent evt) {
        JButton bt = (JButton) evt.getSource();
        System.out.println("Botão clicado:" + bt.getName());
    }

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
            java.util.logging.Logger.getLogger(SelecionaTipoDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelecionaTipoDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelecionaTipoDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelecionaTipoDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SelecionaTipoDocumento form = new SelecionaTipoDocumento();
                form.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane panProcessoColuna1;
    private javax.swing.JScrollPane panProcessoColuna2;
    // End of variables declaration//GEN-END:variables
}

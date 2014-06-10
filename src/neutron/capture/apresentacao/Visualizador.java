/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neutron.capture.apresentacao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.RenderingHints;
import javax.media.jai.Interpolation;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;
import javax.media.jai.operator.ScaleDescriptor;
import javax.media.jai.widget.ScrollingImagePanel;
import neutron.capture.negocio.Controle;
import neutron.capture.negocio.ManipulaImagens;

/**
 *
 * @author max
 */
public class Visualizador extends javax.swing.JFrame {

    private RenderedOp img;
    ScrollingImagePanel panel;
    Dimension tamanhoPainel;

    public Visualizador() {
        initComponents();
        btnVoltar.setBorder(null);
        btnVoltar.setContentAreaFilled(false);
        getContentPane().setBackground(Color.WHITE);
        abrirImagem();
    }

    private void carregaImagem() {
        tamanhoPainel = new Dimension(panVisualizador.getWidth(), panVisualizador.getHeight());
        if (img != null) {
            if (panel == null) {
                panVisualizador.removeAll();
                panel = new ScrollingImagePanel(img, tamanhoPainel.width, tamanhoPainel.width);
                panVisualizador.add(panel, BorderLayout.CENTER);
            } else {
                panel.set(img);
            }
        }
        repaint();
    }

    public final void abrirImagem() {
        javax.swing.GroupLayout panVisualizadorLayout = new javax.swing.GroupLayout(panVisualizador);
        panVisualizador.setLayout(panVisualizadorLayout);
        ManipulaImagens manipulaImg = new ManipulaImagens();
        img = manipulaImg.AbrirArquivoTIF("/home/max/Imagens/Arquivos Importar/00000001.TIF");
        carregaImagem();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVoltar = new javax.swing.JButton();
        panBotoes = new javax.swing.JPanel();
        btnIniciar = new javax.swing.JButton();
        btnParar = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnProxima = new javax.swing.JButton();
        btnEsquerda = new javax.swing.JButton();
        btnDireita = new javax.swing.JButton();
        btnZoomIN = new javax.swing.JButton();
        btnZoomOUT = new javax.swing.JButton();
        btnExcluirPagina = new javax.swing.JButton();
        btnExcluirTodasPaginas = new javax.swing.JButton();
        panVisualizador = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.white);

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/botoes/voltar.png"))); // NOI18N
        btnVoltar.setToolTipText("<html>Voltar para a<br>seleção de<br>tipo de documento</html>");
        btnVoltar.setBorder(null);
        btnVoltar.setBorderPainted(false);
        btnVoltar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/botoes/voltar_sel.png"))); // NOI18N
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        panBotoes.setBackground(java.awt.Color.white);
        panBotoes.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(85, 98, 210)));

        btnIniciar.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(45, 77, 109));
        btnIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/botoes/botao_iniciar.png"))); // NOI18N
        btnIniciar.setToolTipText("Iniciar digitalização");
        btnIniciar.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnIniciar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIniciar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/botoes/botao_iniciar_sel.png"))); // NOI18N

        btnParar.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnParar.setForeground(new java.awt.Color(45, 77, 109));
        btnParar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/botoes/botao_parar.png"))); // NOI18N
        btnParar.setToolTipText("Parar digitalização");
        btnParar.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnParar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnParar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/botoes/botao_parar_sel.png"))); // NOI18N

        btnAnterior.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnAnterior.setForeground(new java.awt.Color(45, 77, 109));
        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/botoes/botao_anterior.png"))); // NOI18N
        btnAnterior.setToolTipText("Página anterior");
        btnAnterior.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnAnterior.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAnterior.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/botoes/botao_anterior_sel.png"))); // NOI18N

        btnProxima.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnProxima.setForeground(new java.awt.Color(45, 77, 109));
        btnProxima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/botoes/botao_proximo.png"))); // NOI18N
        btnProxima.setToolTipText("Próxima página");
        btnProxima.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnProxima.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProxima.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/botoes/botao_proximo_sel.png"))); // NOI18N

        btnEsquerda.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnEsquerda.setForeground(new java.awt.Color(45, 77, 109));
        btnEsquerda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/botoes/botao_esquerda.png"))); // NOI18N
        btnEsquerda.setToolTipText("Girar para esquerda");
        btnEsquerda.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnEsquerda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEsquerda.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/botoes/botao_esquerda_sel.png"))); // NOI18N

        btnDireita.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnDireita.setForeground(new java.awt.Color(45, 77, 109));
        btnDireita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/botoes/botao_direita.png"))); // NOI18N
        btnDireita.setToolTipText("Girar para direita");
        btnDireita.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnDireita.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDireita.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/botoes/botao_direita_selecionado.png"))); // NOI18N

        btnZoomIN.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnZoomIN.setForeground(new java.awt.Color(45, 77, 109));
        btnZoomIN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/botoes/botao_zoom_in.png"))); // NOI18N
        btnZoomIN.setToolTipText("Aumentar o zoom");
        btnZoomIN.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnZoomIN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnZoomIN.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/botoes/botao_zoom_in_sel.png"))); // NOI18N
        btnZoomIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoomIN_Click(evt);
            }
        });

        btnZoomOUT.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnZoomOUT.setForeground(new java.awt.Color(45, 77, 109));
        btnZoomOUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/botoes/botao_zoom_out.png"))); // NOI18N
        btnZoomOUT.setToolTipText("Diminuir o zoom");
        btnZoomOUT.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnZoomOUT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnZoomOUT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/botoes/botao_zoom_out_sel.png"))); // NOI18N
        btnZoomOUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoomOut_Click(evt);
            }
        });

        btnExcluirPagina.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnExcluirPagina.setForeground(new java.awt.Color(45, 77, 109));
        btnExcluirPagina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/botoes/botao_excluir_pagina.png"))); // NOI18N
        btnExcluirPagina.setToolTipText("Excluir página");
        btnExcluirPagina.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnExcluirPagina.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluirPagina.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/botoes/botao_excluir_pagina_sel.png"))); // NOI18N

        btnExcluirTodasPaginas.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnExcluirTodasPaginas.setForeground(new java.awt.Color(45, 77, 109));
        btnExcluirTodasPaginas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/botoes/botao_excluir_todas.png"))); // NOI18N
        btnExcluirTodasPaginas.setToolTipText("Excluir todas as páginas");
        btnExcluirTodasPaginas.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnExcluirTodasPaginas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluirTodasPaginas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/botoes/botao_excluir_todas_sel.png"))); // NOI18N

        javax.swing.GroupLayout panBotoesLayout = new javax.swing.GroupLayout(panBotoes);
        panBotoes.setLayout(panBotoesLayout);
        panBotoesLayout.setHorizontalGroup(
            panBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panBotoesLayout.createSequentialGroup()
                        .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnParar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEsquerda, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panBotoesLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(panBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnProxima, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDireita, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnZoomOUT, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExcluirTodasPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnZoomIN, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluirPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panBotoesLayout.setVerticalGroup(
            panBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panBotoesLayout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(btnParar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProxima, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDireita, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnZoomOUT, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluirTodasPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panBotoesLayout.createSequentialGroup()
                        .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEsquerda, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnZoomIN, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluirPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnIniciar.getAccessibleContext().setAccessibleName("btnIniciar1");

        panVisualizador.setBackground(java.awt.Color.white);
        panVisualizador.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(233, 213, 50)));
        panVisualizador.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                panVisualizador_Resized(evt);
            }
        });

        javax.swing.GroupLayout panVisualizadorLayout = new javax.swing.GroupLayout(panVisualizador);
        panVisualizador.setLayout(panVisualizadorLayout);
        panVisualizadorLayout.setHorizontalGroup(
            panVisualizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panVisualizadorLayout.setVerticalGroup(
            panVisualizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)))
                .addComponent(panVisualizador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(panVisualizador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnVoltar)
                .addGap(10, 10, 10)
                .addComponent(panBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panVisualizador_Resized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panVisualizador_Resized
        // TODO add your handling code here:
        for (Component cp : panVisualizador.getComponents()) {
            cp.setSize(panVisualizador.getWidth(), panVisualizador.getHeight());
        }
    }//GEN-LAST:event_panVisualizador_Resized

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        Controle cp = Controle.getInstacia();
        //Testa se algum documento foi adiciona
        cp.getProcesso().getTiposDocumentos()[0].setPaginasCapturadas(1);

        SelecionaTipoDocumento st = new SelecionaTipoDocumento();
        st.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnZoomOut_Click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomOut_Click
        RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_RENDERING,
            RenderingHints.VALUE_RENDER_QUALITY);
        img = JAI.create("SubsampleAverage", img, .9, .9, qualityHints);
        //img = ScaleDescriptor.create(img, (float) .9, (float) .9, 0.0f, 0.0f, Interpolation.getInstance(Interpolation.INTERP_BICUBIC), qualityHints);
        carregaImagem();
    }//GEN-LAST:event_btnZoomOut_Click

    private void btnZoomIN_Click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomIN_Click

        RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_RENDERING,
            RenderingHints.VALUE_RENDER_QUALITY);
        img = ScaleDescriptor.create(img, (float) 1.1, (float) 1.1, 0.0f, 0.0f, Interpolation.getInstance(Interpolation.INTERP_BICUBIC), qualityHints);
        carregaImagem();
    }//GEN-LAST:event_btnZoomIN_Click

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
            java.util.logging.Logger.getLogger(Visualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Visualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Visualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Visualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Visualizador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnDireita;
    private javax.swing.JButton btnEsquerda;
    private javax.swing.JButton btnExcluirPagina;
    private javax.swing.JButton btnExcluirTodasPaginas;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnParar;
    private javax.swing.JButton btnProxima;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton btnZoomIN;
    private javax.swing.JButton btnZoomOUT;
    private javax.swing.JPanel panBotoes;
    private javax.swing.JPanel panVisualizador;
    // End of variables declaration//GEN-END:variables
}

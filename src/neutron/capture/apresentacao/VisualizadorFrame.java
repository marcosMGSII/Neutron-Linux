/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neutron.capture.apresentacao;

import com.sun.media.jai.codec.ByteArraySeekableStream;
import com.sun.media.jai.codec.FileSeekableStream;
import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageDecoder;
import com.sun.media.jai.codec.SeekableStream;
import com.sun.media.jai.codec.TIFFDecodeParam;
import com.sun.media.jai.codec.TIFFEncodeParam;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.RenderedOp;
import javax.media.jai.widget.ScrollingImagePanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import neutron.capture.negocio.JPanelWithBackground;

public class VisualizadorFrame extends javax.swing.JFrame {

    private VisualizaImgem painelImagem;
    private JScrollPane jsp;

    /**
     * Creates new form VisualizadorFrame
     */
    static Image load(byte[] data) throws Exception {
        Image image = null;
        SeekableStream stream = new ByteArraySeekableStream(data);
        String[] names = ImageCodec.getDecoderNames(stream);
        ImageDecoder dec
                = ImageCodec.createImageDecoder(names[0], stream, null);
        RenderedImage im = dec.decodeAsRenderedImage();
        image = PlanarImage.wrapRenderedImage(im).getAsBufferedImage();
        return image;
    }

    protected String getExtension(String name) {
        String[] str = name.split("\\.");
        if (str.length > 1) {
            return str[str.length - 1];
        }

        return ""; //-- no extension
    }

    public VisualizadorFrame() {
        initComponents();
        String path = "/home/max/Imagens/Arquivos Importar/00000001.TIF";
        //path = "/home/max/Imagens/Neutron Capture/Login.jpg";

        if (getExtension(path).toUpperCase().equals("TIF")) {
            File file = new File(path);
            FileSeekableStream stream = null;
            try {
                stream = new FileSeekableStream(file);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(0);
            }

            ParameterBlock params = new ParameterBlock();
            params.add(stream);

            TIFFDecodeParam decodeParam = new TIFFDecodeParam();
            decodeParam.setDecodePaletteAsShorts(true);

            RenderedOp image1 = JAI.create("tiff", params, null);

            int dataType = image1.getSampleModel().getDataType();

            RenderedOp image2 = null;
            if (dataType == DataBuffer.TYPE_BYTE) {
                System.out.println("TIFF image is type byte.");
                image2 = image1;
            } else {
                System.out.println("TIFF image is type " + dataType
                        + ", and will not be displayed.");
                System.exit(0);
            }

            int width = image2.getWidth();
            int height = image2.getHeight();

            ScrollingImagePanel panel = new ScrollingImagePanel(image2, 450, 400);
            setPreferredSize(new Dimension(500, 500));
            getContentPane().add(panel, BorderLayout.CENTER);
            panel.revalidate();
            getContentPane().repaint();
            System.out.println("" + image2.getWidth());
        } else {
            if (getExtension(path).toUpperCase().equals("JPG")) {
                getContentPane().setLayout(null);
                setPreferredSize(new Dimension(500, 500));
                jsp = new JScrollPane();
                jsp.setSize(400,400);
                jsp.setPreferredSize(new Dimension(400, 400));
                getContentPane().add(jsp);
                JPanelWithBackground background = new JPanelWithBackground(path);
                background.setSize(background.getAlturaImagem(), background.getWidth());
                background.setPreferredSize(new Dimension(background.getAlturaImagem(), background.getWidth()));
                jsp.setViewportView(background);
            }
        }

    }

    public class VisualizaImgem extends JPanel {

        private static final long serialVersionUID = 1L;
        private Image img;

        public VisualizaImgem() {
        }

        public VisualizaImgem(Image img) {
            setImg(img);
        }

        public VisualizaImgem(String url) {
            setImg(img);
        }

        public Image getImg() {
            return img;
        }

        protected void paintComponent(final Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        }

        public void setImg(Image img) {
            this.img = img;
            this.repaint();
        }

        public void setImg(String url) {
            setImg(Toolkit.getDefaultToolkit().createImage(url));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

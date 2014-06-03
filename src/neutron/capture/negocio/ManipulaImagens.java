/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neutron.capture.negocio;

import com.sun.media.jai.codec.FileSeekableStream;
import com.sun.media.jai.codec.TIFFDecodeParam;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;
import javax.media.jai.widget.ScrollingImagePanel;
import javax.swing.JScrollPane;

/**
 *
 * @author max
 */
public class ManipulaImagens {

    private int largura;
    private int altura;

    protected String getExtension(String name) {
        String[] str = name.split("\\.");
        if (str.length > 1) {
            return str[str.length - 1].toUpperCase();
        }
        return ""; //-- Não possui extensão
    }

    public RenderedOp AbrirArquivoTIF(String nomeArquivo) {
        if (getExtension(nomeArquivo).equals("TIF")) {
            Boolean falhaAbrirAruivo = false;
            File file = new File(nomeArquivo);
            FileSeekableStream stream = null;
            try {
                stream = new FileSeekableStream(file);
            } catch (IOException e) {
                falhaAbrirAruivo = true;
            }
            //Adiciona o arquivo para o Parametro
            ParameterBlock params = new ParameterBlock();
            params.add(stream);
            //Define o decodficador para ler arquivo tif
            TIFFDecodeParam decodeParam = new TIFFDecodeParam();
            decodeParam.setDecodePaletteAsShorts(true);
            //Cria um objeto com a Imagem
            RenderedOp imagemJAI = JAI.create("tiff", params, null);
            //Recupera o tipo da Imagem
            int dataType = imagemJAI.getSampleModel().getDataType();
            //Verifica se o arquivo TIF pode ser lido
            RenderedOp imagemTIF;
            if (dataType == DataBuffer.TYPE_BYTE) {
                imagemTIF = imagemJAI;
                largura = imagemTIF.getWidth();
                altura = imagemTIF.getHeight();
                return imagemTIF;
            }
        }
        //Caso não seja um arquivo TIF válido retorna null
        return null;
    }

    public Image AbrirArquivoJPG(String nomeArquivo) {
        if (getExtension(nomeArquivo).equals("JPG")) {
            BufferedImage buffer;
            try {
                buffer = ImageIO.read(new File(nomeArquivo));
                altura = buffer.getHeight();
                largura = buffer.getWidth();
                return buffer;
            } catch (IOException ex) {
                Logger.getLogger(ManipulaImagens.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Caso não seja um arquivo JPG válido retorna null
        return null;
    }
}

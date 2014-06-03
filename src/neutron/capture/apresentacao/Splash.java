/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neutron.capture.apresentacao;

import com.thehowtotutorial.splashscreen.JSplash;
import java.awt.Color;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author max
 */
public class Splash {

    public Splash() {
        JSplash telaSplash = new JSplash(Splash.class.getResource(File.separator + "resources" + File.separator + "Imagens" + File.separator + "Splash.jpg"), true, true, false, "Versão 2.0.0.42     ", new java.awt.Font("SansSerif", 1, 12), Color.BLACK, Color.BLACK);        
        
        telaSplash.splashOn();
        try {
            Thread.sleep(1000);
            telaSplash.setProgress(33, "Inicializando...");
            Thread.sleep(1000);
            telaSplash.setProgress(66, "Carregando...");
            Thread.sleep(1000);
            telaSplash.setProgress(80, "Iniciando Aplicação...");
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
        telaSplash.splashOff();
    }

}

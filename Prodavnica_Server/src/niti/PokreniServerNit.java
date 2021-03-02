/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nikola
 */
public class PokreniServerNit extends Thread {
    ServerSocket ss;
    static List<ObradaZahtevaNit> klijenti = new ArrayList<>();
    @Override
    public void run() {
        try {
             ss = new ServerSocket(9000);
            while(true) {
                Socket s = ss.accept();
                ObradaZahtevaNit ozn = new ObradaZahtevaNit(s);
                ozn.start();
                klijenti.add(ozn);
            }
        } catch (IOException ex) {
            //Logger.getLogger(PokreniServerNit.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Server je uspešno zaustavljen");
        }
    }
    
    public void zaustaviNiti() {
        try {
            ss.close();
            for (ObradaZahtevaNit klijentNit : klijenti) {
                klijentNit.getS().close();
            }
        } catch (IOException ioe) {
            Logger.getLogger(PokreniServerNit.class.getName()).log(Level.SEVERE, null, ioe);
        }
    }
    
}

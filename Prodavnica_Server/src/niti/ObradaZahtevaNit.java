/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import controller.Controller;
import domain.Artikal;
import domain.JedinicaMere;
import domain.Kupac;
import domain.Narudzbina;
import domain.PoreskaStopa;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Operacije;
import pomocna.PretragaNarudzbina;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Nikola
 */
public class ObradaZahtevaNit extends Thread{
    Socket s;

    public ObradaZahtevaNit(Socket s) {
        this.s = s;
    }

    public Socket getS() {
        return s;
    }

    public void setS(Socket s) {
        this.s = s;
    }
    
    @Override
    public void run() {
        while(true) {
            KlijentskiZahtev kz = primiZahtev();
            ServerskiOdgovor so = new ServerskiOdgovor();
            
            switch(kz.getOperacija()) {
                case Operacije.vrati_kupce:
                    try {
                    String[] parametriZaKupce = (String[]) kz.getParametar();
                    ArrayList<Kupac> listaKupaca = Controller.getInstance().vratiKupce(parametriZaKupce);
                    so.setParametar(listaKupaca);
                    } catch(Exception e) {
                        System.out.println("Exception!");
                    }
                    break;
                case Operacije.vrati_pretragu_narudzbina:
                    try {
                    String[] parametri = (String[]) kz.getParametar();
                    ArrayList<PretragaNarudzbina> listaNarudzbina = Controller.getInstance().vratiNarudzbine(parametri);
                    so.setParametar(listaNarudzbina);
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case Operacije.vrati_artikle:
                    try {
                    ArrayList<Artikal> listaArtikala = Controller.getInstance().vratiArtikle();
                    so.setParametar(listaArtikala);
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case Operacije.sacuvaj_narudzbinu:
                    try {
                    Narudzbina n = (Narudzbina) kz.getParametar();
                    boolean uspesno = Controller.getInstance().sacuvajNarudzbinu(n);
                    so.setParametar(uspesno);
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case Operacije.vrati_jednu_narudzbinu:
                    try {
                    String[] parametri2 = (String[]) kz.getParametar();
                    Narudzbina narudzbina = Controller.getInstance().vratiOdredjenuNarudzbinu(parametri2);
                    so.setParametar(narudzbina);
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case Operacije.izmeni_narudzbinu:
                    try {
                    Narudzbina n1 = (Narudzbina) kz.getParametar();
                    boolean uspesno1 = Controller.getInstance().izmeniNarudzbinu(n1);
                    so.setParametar(uspesno1);
                    } catch(Exception ex) {
                        ex.printStackTrace();
                    }
                    break;
                case Operacije.obrisi_narudzbinu:
                    int narudzbinaID = (int) kz.getParametar();
                    boolean uspesno2 = Controller.getInstance().obrisiNarudzbinu(narudzbinaID);
                    so.setParametar(uspesno2);
                    break;
                case Operacije.unesi_kupca:
                    Kupac k = (Kupac) kz.getParametar();
                    boolean uspesno3 = Controller.getInstance().unesiKupca(k);
                    so.setParametar(uspesno3);
                    break;
                case Operacije.izmeni_kupca:
                    Kupac k1 = (Kupac) kz.getParametar();
                    boolean uspesno4 = Controller.getInstance().izmeniKupca(k1);
                    so.setParametar(uspesno4);
                    break;
                case Operacije.obrisi_kupca:
                    int kupacID = (int) kz.getParametar();
                    boolean uspesno5 = Controller.getInstance().obrisiKupca(kupacID);
                    so.setParametar(uspesno5);
                    break;
                case Operacije.vrati_jedinice_mere:
                    ArrayList<JedinicaMere> listajm = Controller.getInstance().vratiJM();
                    so.setParametar(listajm);
                    break;
                case Operacije.vrati_poreze:
                    ArrayList<PoreskaStopa> listaps = Controller.getInstance().vratiPS();
                    so.setParametar(listaps);
                    break;
                case Operacije.sacuvaj_artikal:
                    Artikal a = (Artikal) kz.getParametar();
                    boolean uspesno6 = Controller.getInstance().sacuvajArtikal(a);
                    so.setParametar(uspesno6);
                    break;
            }
            posaljiOdgovor(so);
        }
    }
    
    public KlijentskiZahtev primiZahtev() {
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            return (KlijentskiZahtev) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ObradaZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void posaljiOdgovor(ServerskiOdgovor so) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(so);
        } catch (IOException ex) {
            Logger.getLogger(ObradaZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

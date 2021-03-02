/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domain.Artikal;
import domain.JedinicaMere;
import domain.Kupac;
import domain.Narudzbina;
import domain.PoreskaStopa;
import java.util.ArrayList;
import komunikacija.Komunikacija;
import konstante.Operacije;
import pomocna.PretragaNarudzbina;
import transfer.KlijentskiZahtev;

/**
 *
 * @author Nikola
 */
public class KontrolerKI {
    private static KontrolerKI instance;
    
    private KontrolerKI() {
    
    }
    
    public static KontrolerKI getInstance() {
        if(instance == null)
            instance = new KontrolerKI();
        return instance;
    }
    
    public ArrayList<PretragaNarudzbina> vratiNarudzbine(String [] parametri) {
        
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.vrati_pretragu_narudzbina);
        kz.setParametar(parametri);
        Komunikacija.getInstance().posaljiZahtev(kz);
        
        ArrayList<PretragaNarudzbina> lista = (ArrayList<PretragaNarudzbina>) Komunikacija.getInstance().primiOdgovor().getParametar();
        return lista;
        
    }
    
    public Narudzbina vratiJednuNarudzbinu(String[] parametri) {
        
       KlijentskiZahtev kz = new KlijentskiZahtev();
       kz.setOperacija(Operacije.vrati_jednu_narudzbinu);
       kz.setParametar(parametri);
       Komunikacija.getInstance().posaljiZahtev(kz);
       
       Narudzbina n = (Narudzbina) Komunikacija.getInstance().primiOdgovor().getParametar();
       return n;
        
    }

    public boolean obrisiNarudzbinu(int narudzbinaID) {
       KlijentskiZahtev kz = new KlijentskiZahtev();
       kz.setOperacija(Operacije.obrisi_narudzbinu);
       kz.setParametar(narudzbinaID);
       Komunikacija.getInstance().posaljiZahtev(kz);
       boolean uspesno = (boolean) Komunikacija.getInstance().primiOdgovor().getParametar();
       return uspesno;
    }

    public ArrayList<Kupac> vratiKupce(String[] parametri) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.vrati_kupce);
        //String[] parametri = {"",""};
        kz.setParametar(parametri);
        Komunikacija.getInstance().posaljiZahtev(kz);
        
        ArrayList<Kupac> lista = (ArrayList<Kupac>) Komunikacija.getInstance().primiOdgovor().getParametar();
        return lista;
    }

    public boolean sacuvajNarudzbinu(Narudzbina n) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.sacuvaj_narudzbinu);
        kz.setParametar(n);
        Komunikacija.getInstance().posaljiZahtev(kz);
        
        boolean uspesno = (boolean) Komunikacija.getInstance().primiOdgovor().getParametar();
        return uspesno;
    }

    public ArrayList<Artikal> vratiArtikle() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.vrati_artikle);
        Komunikacija.getInstance().posaljiZahtev(kz);
        
        ArrayList<Artikal> lista = (ArrayList<Artikal>) Komunikacija.getInstance().primiOdgovor().getParametar();
        return lista;
    }

    public boolean izmeniNarudzbinu(Narudzbina n) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.izmeni_narudzbinu);
        kz.setParametar(n);
        Komunikacija.getInstance().posaljiZahtev(kz);

        boolean uspesno = (boolean) Komunikacija.getInstance().primiOdgovor().getParametar();
        return uspesno;
    }

    public boolean obrisiKupca(int kupacid) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.obrisi_kupca);
        kz.setParametar(kupacid);
        Komunikacija.getInstance().posaljiZahtev(kz);
        
        boolean uspesno = (boolean) Komunikacija.getInstance().primiOdgovor().getParametar();
        return uspesno;
    }

    public boolean izmeniKupca(Kupac k) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.izmeni_kupca);
        kz.setParametar(k);
        Komunikacija.getInstance().posaljiZahtev(kz);
        boolean uspesno = (boolean) Komunikacija.getInstance().primiOdgovor().getParametar();
        return uspesno;
    }

    public boolean unesiKupca(Kupac k) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.unesi_kupca);
        kz.setParametar(k);
        Komunikacija.getInstance().posaljiZahtev(kz);
        boolean uspesno = (boolean) Komunikacija.getInstance().primiOdgovor().getParametar();
        return uspesno;
    }

    public boolean sacuvajArtikal(Artikal a) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.sacuvaj_artikal);
        kz.setParametar(a);
        Komunikacija.getInstance().posaljiZahtev(kz);
        
        boolean uspesno = (boolean) Komunikacija.getInstance().primiOdgovor().getParametar();
        return uspesno;
    }

    public ArrayList<JedinicaMere> vratiJediniceMere() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.vrati_jedinice_mere);
        Komunikacija.getInstance().posaljiZahtev(kz);
        
        ArrayList<JedinicaMere> lista = (ArrayList<JedinicaMere>) Komunikacija.getInstance().primiOdgovor().getParametar();
        return lista;
    }

    public ArrayList<PoreskaStopa> vratiPoreze() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.vrati_poreze);
        Komunikacija.getInstance().posaljiZahtev(kz);
        
        ArrayList<PoreskaStopa> lista = (ArrayList<PoreskaStopa>) Komunikacija.getInstance().primiOdgovor().getParametar();
        return lista;
    }
    
    
    
    
    
    
    
}

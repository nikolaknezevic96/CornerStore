/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbb.DBBroker;
import domain.Artikal;
import domain.JedinicaMere;
import domain.Kupac;
import domain.Narudzbina;
import domain.PoreskaStopa;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pomocna.PretragaNarudzbina;
import so.IzmeniKupcaSO;
import so.IzmeniNarudzbinuSO;
import so.KreirajNarudzbinuSO;
import so.ObrisiKupcaSO;
import so.ObrisiNarudzbinuSO;
import so.OpstaSO;
import so.PronadjiNarudzbinuSO;
import so.UnesiArtikalSO;
import so.UnesiKupcaSO;
import so.VratiArtikleSO;
import so.VratiJMSO;
import so.VratiNarudzbineSO;
import so.VratiPSSO;
import so.vratiKupceSO;

/**
 *
 * @author Nikola
 */
public class Controller {
    private static Controller instance;
    
    private Controller() {
        
    }
    
    public static Controller getInstance() {
        if(instance == null)
            instance = new Controller();
        return instance;
    }

    public ArrayList<Kupac> vratiKupce(String[] parametri) throws Exception {
        vratiKupceSO vratiKupce = new vratiKupceSO();
        vratiKupce.izvrsiOperaciju(parametri);
        ArrayList<Kupac> listaKupaca = (ArrayList<Kupac>)(ArrayList<?>) vratiKupce.getLista();
        return listaKupaca;
    }

    public ArrayList<PretragaNarudzbina> vratiNarudzbine(String[] parametri) throws Exception {
        VratiNarudzbineSO vn = new VratiNarudzbineSO();
        vn.izvrsiOperaciju(parametri);
        ArrayList<PretragaNarudzbina> listaNarudzbina = (ArrayList<PretragaNarudzbina>)(ArrayList<?>) vn.getLista();
        return listaNarudzbina;
    }

    public ArrayList<Artikal> vratiArtikle() throws Exception {
        VratiArtikleSO va = new VratiArtikleSO();
        va.izvrsiOperaciju(null);
        ArrayList<Artikal> listaArtikala = (ArrayList<Artikal>)(ArrayList<?>) va.getLista();
        return listaArtikala;
    }

    public boolean sacuvajNarudzbinu(Narudzbina n) throws Exception {
        KreirajNarudzbinuSO sn = new KreirajNarudzbinuSO();
        sn.setN(n);
        sn.izvrsiOperaciju(n);
        return sn.isUspesno();
    }

    public Narudzbina vratiOdredjenuNarudzbinu(String[] parametri2) throws Exception {    
            PronadjiNarudzbinuSO pn = new PronadjiNarudzbinuSO();
            pn.izvrsiOperaciju(parametri2);
            return pn.getN();
         
    }

    public boolean izmeniNarudzbinu(Narudzbina n) throws Exception {
        IzmeniNarudzbinuSO in = new IzmeniNarudzbinuSO();
        in.setN(n);
        in.izvrsiOperaciju(n);
        return in.isUspesno();
    }

    public boolean obrisiNarudzbinu(int id) {
        try {
            ObrisiNarudzbinuSO on = new ObrisiNarudzbinuSO();
            on.setId(id);
            on.izvrsiOperaciju(id);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean unesiKupca(Kupac k) {
        try {
            UnesiKupcaSO uk = new UnesiKupcaSO();
            uk.setK(k);
            uk.izvrsiOperaciju(k);
            return uk.isUspesno();
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean izmeniKupca(Kupac k) {
        try {
            IzmeniKupcaSO ik = new IzmeniKupcaSO();
            ik.setK(k);
            ik.izvrsiOperaciju(k);
            return ik.isUspesno();
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean obrisiKupca(int kupacID) {
        try {
            ObrisiKupcaSO ok = new ObrisiKupcaSO();
            ok.setId(kupacID);
            ok.izvrsiOperaciju(kupacID);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<JedinicaMere> vratiJM() {
        try {
            VratiJMSO vj = new VratiJMSO();
            vj.izvrsiOperaciju(null);
            ArrayList<JedinicaMere> listaJM = (ArrayList<JedinicaMere>)(ArrayList<?>) vj.getLista();
            return listaJM;
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<PoreskaStopa> vratiPS() {
        try {
            VratiPSSO vp = new VratiPSSO();
            vp.izvrsiOperaciju(null);
            ArrayList<PoreskaStopa> listaPS = (ArrayList<PoreskaStopa>)(ArrayList<?>) vp.getLista();
            return listaPS;
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean sacuvajArtikal(Artikal a) {
        try {
            UnesiArtikalSO ua = new UnesiArtikalSO();
            ua.setA(a);
            ua.izvrsiOperaciju(a);
            return ua.isUspesno();
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}

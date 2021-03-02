/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import dbb.DBBroker;
import domain.InterfaceObjekat;
import domain.Narudzbina;
import domain.StavkaNarudzbine;
import java.util.ArrayList;

/**
 *
 * @author Nikola
 */
public class PronadjiNarudzbinuSO extends OpstaSO {
    Narudzbina n = new Narudzbina();
    ArrayList<InterfaceObjekat> lista = new ArrayList<>();
    
    public Narudzbina getN() {
        return n;
    }

    public void setN(Narudzbina n) {
        this.n = n;
    }
    
    
    @Override
    public void proveriPreduslov(Object obj) throws Exception {
        return;
    }

    @Override
    public void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        String[] parametri = (String[]) obj;
        ArrayList<StavkaNarudzbine> listaStavki = new ArrayList<>();
        ArrayList<InterfaceObjekat> listaInterfaceStavki = new ArrayList<>();
        String dodatak = "";
        if(!parametri[0].equals("")) {
            dodatak = " and a.naziv = '" + parametri[0] + "'";
        }
        String sql = "select * from narudzbina n join kupac k on n.kupacID=k.kupacID where NarudzbinaID=" + parametri[1];
        
        lista = DBBroker.getInstance().vrati(n, sql);
        n = (Narudzbina) lista.get(0);
        
        StavkaNarudzbine stavka = new StavkaNarudzbine();
        String sql1 = "select * from stavkanarudzbine s join artikal a on s.ArtikalID=a.ArtikalID join jedinicamere j on a.JedinicaMereID=j.JedinicaMereID join poreskastopa p on a.PoreskaStopaID=p.PoreskaStopaID where s.NarudzbinaID= " + parametri[1] + dodatak;
        
        listaInterfaceStavki = DBBroker.getInstance().vrati(stavka, sql1);
        listaStavki = (ArrayList<StavkaNarudzbine>)(ArrayList<?>) listaInterfaceStavki;
        System.out.println(listaStavki.get(0).getIznos());
        n.setLista(listaStavki);
        
    }
    
}

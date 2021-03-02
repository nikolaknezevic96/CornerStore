/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import dbb.DBBroker;
import domain.InterfaceObjekat;
import java.util.ArrayList;
import pomocna.PretragaNarudzbina;

/**
 *
 * @author Nikola
 */
public class VratiNarudzbineSO extends OpstaSO {
    ArrayList<InterfaceObjekat> lista = new ArrayList<>();

    public ArrayList<InterfaceObjekat> getLista() {
        return lista;
    }

    public void setLista(ArrayList<InterfaceObjekat> lista) {
        this.lista = lista;
    }
    
    
    @Override
    public void proveriPreduslov(Object obj) throws Exception {
        return;
    }

    @Override
    public void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        String[] parametri = (String[]) obj;
        String dodatak = "";
     
        if(!parametri[0].equals("")) {
            dodatak += "and n.datum = '" + parametri[0] + "'";
        }
        
        if(!parametri[1].equals("")) {
            dodatak += "and n.kupacid = "+ parametri[1];
        }
        String sql = "select n.NarudzbinaID,n.datum,k.ime,k.prezime,k.telefon, GROUP_CONCAT(concat(a.naziv,':'),concat(s.kolicina,' ',j.naziv) SEPARATOR ' , ') as stavke,n.ukupnaCena from Narudzbina n join stavkanarudzbine s on n.NarudzbinaID=s.NarudzbinaID join kupac k on n.kupacID=k.kupacID join artikal a on s.ArtikalID = a.ArtikalID join jedinicamere j on j.JedinicaMereID=a.JedinicaMereID where 1=1 "+dodatak+" group by n.NarudzbinaID";
        PretragaNarudzbina pn = new PretragaNarudzbina();
        lista = DBBroker.getInstance().vrati(pn, sql);
       
    }
    
}

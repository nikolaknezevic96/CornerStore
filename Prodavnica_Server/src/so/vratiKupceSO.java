/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import dbb.DBBroker;
import domain.InterfaceObjekat;
import domain.Kupac;
import java.util.ArrayList;

/**
 *
 * @author Nikola
 */
public class vratiKupceSO extends OpstaSO {
    
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
        Kupac k = new Kupac();
        String dodatak = "";
        if(!parametri[0].equals("")) {
            dodatak += " and ime = '" + parametri[0] + "'";
        }
        if(!parametri[1].equals("")) {
            dodatak += " and prezime = '" + parametri[1] + "'";
        }
        String sql = "select * from kupac where 1=1" + dodatak;
        
        lista = DBBroker.getInstance().vrati(k, sql);
    
    }
    
}

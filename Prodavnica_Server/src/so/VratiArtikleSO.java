/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import dbb.DBBroker;
import domain.Artikal;
import domain.InterfaceObjekat;
import java.util.ArrayList;

/**
 *
 * @author Nikola
 */
public class VratiArtikleSO extends OpstaSO {
    
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
        Artikal a = new Artikal();
        String sql = "select * from artikal a join JedinicaMere j on a.JedinicaMereID=j.JedinicaMereID join poreskastopa p on a.PoreskaStopaID=p.PoreskaStopaID";
        
        lista = DBBroker.getInstance().vrati(a, sql);
    }
    
}

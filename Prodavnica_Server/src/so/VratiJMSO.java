/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import dbb.DBBroker;
import domain.InterfaceObjekat;
import domain.JedinicaMere;
import java.util.ArrayList;

/**
 *
 * @author Nikola
 */
public class VratiJMSO extends OpstaSO{

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
        JedinicaMere jm = new JedinicaMere();
        String sql = "select * from jedinicamere";
        lista = DBBroker.getInstance().vrati(jm, sql);
    }
    
}

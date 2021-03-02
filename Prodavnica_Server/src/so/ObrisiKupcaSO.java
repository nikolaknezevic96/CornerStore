/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import dbb.DBBroker;
import domain.Kupac;

/**
 *
 * @author Nikola
 */
public class ObrisiKupcaSO extends OpstaSO{
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public void proveriPreduslov(Object obj) throws Exception {
        return;
    }

    @Override
    public void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        Kupac k = new Kupac();
        DBBroker.getInstance().obrisi(k, id);
    }
    
}

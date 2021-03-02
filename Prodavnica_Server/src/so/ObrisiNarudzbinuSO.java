/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import dbb.DBBroker;
import domain.Narudzbina;

/**
 *
 * @author Nikola
 */
public class ObrisiNarudzbinuSO extends OpstaSO{
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
        Narudzbina n = new Narudzbina();
        DBBroker.getInstance().obrisi(n, id);
    }
}

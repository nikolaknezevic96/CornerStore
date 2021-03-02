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
public class UnesiKupcaSO extends OpstaSO {
    
    boolean uspesno = false;
    Kupac k;

    public Kupac getK() {
        return k;
    }

    public void setK(Kupac k) {
        this.k = k;
    }

    public boolean isUspesno() {
        return uspesno;
    }

    public void setUspesno(boolean uspesno) {
        this.uspesno = uspesno;
    }
    
    @Override
    public void proveriPreduslov(Object obj) throws Exception {
        return;
    }

    @Override
    public void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
       
       uspesno = DBBroker.getInstance().sacuvaj(k);
    }
    
}

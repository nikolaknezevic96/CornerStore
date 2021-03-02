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
public class IzmeniNarudzbinuSO extends OpstaSO{
    boolean uspesno = false;
    Narudzbina n;

    public boolean isUspesno() {
        return uspesno;
    }

    public void setUspesno(boolean uspesno) {
        this.uspesno = uspesno;
    }

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
        uspesno = DBBroker.getInstance().izmeni(n);
    }
    
}

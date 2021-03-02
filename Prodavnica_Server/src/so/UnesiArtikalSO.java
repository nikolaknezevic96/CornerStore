/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import dbb.DBBroker;
import domain.Artikal;

/**
 *
 * @author Nikola
 */
public class UnesiArtikalSO extends OpstaSO {
    boolean uspesno = false;
    Artikal a;

    public Artikal getA() {
        return a;
    }

    public void setA(Artikal a) {
        this.a = a;
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
        a.setArtikalID(DBBroker.getInstance().vratiMaxIdArtikal());
       uspesno = DBBroker.getInstance().sacuvaj(a);
    }
    
}

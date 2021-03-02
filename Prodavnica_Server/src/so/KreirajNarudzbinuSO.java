/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import dbb.DBBroker;
import domain.Narudzbina;
import domain.StavkaNarudzbine;

/**
 *
 * @author Nikola
 */
public class KreirajNarudzbinuSO extends OpstaSO{
    Narudzbina n;
    boolean uspesno = false;

    public Narudzbina getN() {
        return n;
    }

    public void setN(Narudzbina n) {
        this.n = n;
    }

    public boolean isUspesno() {
        return uspesno;
    }

    public void setUspesno(boolean uspesno) {
        this.uspesno = uspesno;
    }
    
    
    @Override
    public void proveriPreduslov(Object obj) throws Exception {
        
    }

    @Override
    public void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        n.setNarudzbinaid(DBBroker.getInstance().vratiMaxIdNarudzbina());
        n.setDatum(new java.sql.Date(n.getDatum().getTime()));
        DBBroker.getInstance().sacuvaj(n);
        for(StavkaNarudzbine s : n.getLista()) {
            s.setNarudzbinaid(n.getNarudzbinaid());
            s.setRedniBroj(DBBroker.getInstance().vratiMaxRbStavka());
            DBBroker.getInstance().sacuvaj(s);
        }
        uspesno = true;
    }
    
    
}

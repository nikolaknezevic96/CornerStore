/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import dbb.DBBroker;

/**
 *
 * @author Nikola
 */
public abstract class OpstaSO {
    
    
    public final void izvrsiOperaciju(Object obj) throws Exception {
        try {
            
            otvoriKonekciju();
            proveriPreduslov(obj);
            izvrsiKonkretnuOperaciju(obj);
            commit();
        } catch (Exception ex) {
            rollback();
            throw ex;
        } finally {
            zatvoriKonekciju();
        }
        
    }
    
    private void otvoriKonekciju() throws Exception {
        DBBroker.getInstance().otvoriKonekciju();
    }

    public abstract void proveriPreduslov(Object obj) throws Exception;
    
    public abstract void izvrsiKonkretnuOperaciju(Object obj) throws Exception;
    
    private void commit() throws Exception {
        DBBroker.getInstance().commit();
    }
    
    private void rollback() throws Exception {
        DBBroker.getInstance().rollback();
    }
    
    private void zatvoriKonekciju() throws Exception {
        DBBroker.getInstance().zatvoriKonekciju();
    }
}

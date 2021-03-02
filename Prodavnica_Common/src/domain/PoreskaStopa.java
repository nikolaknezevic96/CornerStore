/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nikola
 */
public class PoreskaStopa implements InterfaceObjekat {
    int poreskastopaid;
    String naziv;
    double iznosStope;

    public PoreskaStopa() {
    }

    public PoreskaStopa(int poreskastopaid, String naziv, double iznosStope) {
        this.poreskastopaid = poreskastopaid;
        this.naziv = naziv;
        this.iznosStope = iznosStope;
    }

    public int getPoreskastopaid() {
        return poreskastopaid;
    }

    public void setPoreskastopaid(int poreskastopaid) {
        this.poreskastopaid = poreskastopaid;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getIznosStope() {
        return iznosStope;
    }

    public void setIznosStope(double iznosStope) {
        this.iznosStope = iznosStope;
    }

    @Override
    public String toString() {
        return naziv; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiNazivTabele() {
        return "poreskastopa";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return null;
    }

    @Override
    public ArrayList<InterfaceObjekat> ucitaj(ResultSet rs) throws Exception {
        ArrayList<InterfaceObjekat> lista = new ArrayList<>();
        while(rs.next()) {
                PoreskaStopa p = new PoreskaStopa();
                p.setPoreskastopaid(rs.getInt("poreskastopaid"));
                p.setNaziv(rs.getString("naziv"));
                p.setIznosStope(rs.getDouble("iznosstope"));
                lista.add(p);
            }
        return lista;
    }

    @Override
    public String getIdKlase() {
        return "poreskastopaid";
    }

    @Override
    public String getSpoljniKljucKlase() {
        return null;
    }
    
    
}

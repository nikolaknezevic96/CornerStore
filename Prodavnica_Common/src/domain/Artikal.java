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
public class Artikal implements InterfaceObjekat{
    int artikalID;
    String naziv;
    double cenaBezporeza;
    PoreskaStopa ps;
    JedinicaMere jm;

    public Artikal() {
    }

    public Artikal(int artikalID, String naziv, double cenaBezporeza, PoreskaStopa ps, JedinicaMere jm) {
        this.artikalID = artikalID;
        this.naziv = naziv;
        this.cenaBezporeza = cenaBezporeza;
        this.ps = ps;
        this.jm = jm;
    }

    public int getArtikalID() {
        return artikalID;
    }

    public void setArtikalID(int artikalID) {
        this.artikalID = artikalID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCenaBezporeza() {
        return cenaBezporeza;
    }

    public void setCenaBezporeza(double cenaBezporeza) {
        this.cenaBezporeza = cenaBezporeza;
    }

    public PoreskaStopa getPs() {
        return ps;
    }

    public void setPs(PoreskaStopa ps) {
        this.ps = ps;
    }

    public JedinicaMere getJm() {
        return jm;
    }

    public void setJm(JedinicaMere jm) {
        this.jm = jm;
    }

    @Override
    public String toString() {
        return naziv; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiNazivTabele() {
        return "artikal";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return artikalID+",'"+naziv + "'," + cenaBezporeza + ",'"+ ps.getPoreskastopaid() +"', "+jm.getJedinicaMereID();
    }

    @Override
    public ArrayList<InterfaceObjekat> ucitaj(ResultSet rs) throws Exception {
        try {
            ArrayList<InterfaceObjekat> lista = new ArrayList<>();
            while(rs.next()) {
                Artikal a = new Artikal();
                a.setArtikalID(rs.getInt("a.artikalid"));
                a.setCenaBezporeza(rs.getDouble("a.cenabezporeza"));
                JedinicaMere jm = new JedinicaMere();
                jm.setJedinicaMereID(rs.getInt("j.jedinicamereid"));
                jm.setNaziv(rs.getString("j.naziv"));
                a.setJm(jm);
                a.setNaziv(rs.getString("a.naziv"));
                PoreskaStopa ps = new PoreskaStopa();
                ps.setPoreskastopaid(rs.getInt("p.poreskastopaid"));
                ps.setNaziv(rs.getString("p.naziv"));
                ps.setIznosStope(rs.getDouble("iznosstope"));
                a.setPs(ps);
                lista.add(a);
            }
            return lista;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public String getIdKlase() {
        return "artikalID";
    }

    @Override
    public String getSpoljniKljucKlase() {
        return "PoreskaStopaID,JedinicaMereID";
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nikola
 */
public class Kupac implements InterfaceObjekat {
    int kupacid;
    String ime;
    String prezime;
    String telefon;

    public Kupac() {
    }

    public Kupac(int kupacid, String ime, String prezime, String telefon) {
        this.kupacid = kupacid;
        this.ime = ime;
        this.prezime = prezime;
        this.telefon = telefon;
    }

    public int getKupacid() {
        return kupacid;
    }

    public void setKupacid(int kupacid) {
        this.kupacid = kupacid;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String vratiNazivTabele() {
        return "kupac";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return kupacid+",'"+ime + "','" + prezime + "','"+ telefon + "'";
    }

    @Override
    public ArrayList<InterfaceObjekat> ucitaj(ResultSet rs) throws Exception {
        ArrayList<InterfaceObjekat> lista = new ArrayList<>();
        while(rs.next()) {
                Kupac k = new Kupac();
                k.setIme(rs.getString("ime"));
                k.setPrezime(rs.getString("prezime"));
                k.setKupacid(rs.getInt("kupacid"));
                k.setTelefon(rs.getString("telefon"));
                lista.add(k);
            }
        return lista;
    }

    @Override
    public String getIdKlase() {
        return "KupacID";
    }

    @Override
    public String getSpoljniKljucKlase() {
        return null;
    }
    
    
    
}

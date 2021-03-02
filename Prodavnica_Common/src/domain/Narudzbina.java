/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nikola
 */
public class Narudzbina implements InterfaceObjekat {
    int narudzbinaid;
    Date datum;
    double ukupnaCena;
    Kupac kupac;
    ArrayList<StavkaNarudzbine> lista;

    public Narudzbina() {
        lista = new ArrayList<>();
    }

    public Narudzbina(int narudzbinaid, Date datum, double ukupnaCena, Kupac kupac) {
        this.narudzbinaid = narudzbinaid;
        this.datum = datum;
        this.ukupnaCena = ukupnaCena;
        this.kupac = kupac;
        lista = new ArrayList<>();
    }

    public int getNarudzbinaid() {
        return narudzbinaid;
    }

    public void setNarudzbinaid(int narudzbinaid) {
        this.narudzbinaid = narudzbinaid;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public ArrayList<StavkaNarudzbine> getLista() {
        return lista;
    }

    public void setLista(ArrayList<StavkaNarudzbine> lista) {
        this.lista = lista;
    }

    @Override
    public String vratiNazivTabele() {
        return "narudzbina";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return narudzbinaid+",'"+datum + "'," + ukupnaCena + ","+ kupac.getKupacid();
    }

    @Override
    public ArrayList<InterfaceObjekat> ucitaj(ResultSet rs) throws Exception {
        ArrayList<InterfaceObjekat> ucitanaLista = new ArrayList<>();        
            while(rs.next()) {
                Narudzbina n = new Narudzbina();
                n.setNarudzbinaid(rs.getInt("narudzbinaid"));
                n.setDatum(rs.getDate("datum"));
                n.setUkupnaCena(rs.getDouble("ukupnacena"));
                Kupac k = new Kupac();
                k.setKupacid(rs.getInt("kupacid"));
                k.setIme(rs.getString("ime"));
                k.setPrezime(rs.getString("prezime"));
                k.setTelefon(rs.getString("telefon"));
                n.setKupac(k);
                ucitanaLista.add(n);
            }
        return ucitanaLista; 
    }

    @Override
    public String getIdKlase() {
        return "narudzbinaid";
    }

    @Override
    public String getSpoljniKljucKlase() {
        return "kupacid";
    }
    
    
}

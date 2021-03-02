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
public class StavkaNarudzbine implements InterfaceObjekat{
    int narudzbinaid;
    int redniBroj;
    int kolicina;
    double iznos;
    Artikal artikal;

    public int getNarudzbinaid() {
        return narudzbinaid;
    }

    public void setNarudzbinaid(int narudzbinaid) {
        this.narudzbinaid = narudzbinaid;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public Artikal getArtikal() {
        return artikal;
    }

    public void setArtikal(Artikal artikal) {
        this.artikal = artikal;
    }

    @Override
    public String vratiNazivTabele() {
        return "stavkanarudzbine";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return narudzbinaid+","+redniBroj + "," + kolicina + ","+ iznos + "," + artikal.getArtikalID();
    }

    @Override
    public ArrayList<InterfaceObjekat> ucitaj(ResultSet rs) throws Exception {
        ArrayList<InterfaceObjekat> ucitanaLista = new ArrayList<>();
        while(rs.next()) {
                StavkaNarudzbine stavka = new StavkaNarudzbine();
                stavka.setNarudzbinaid(rs.getInt("s.narudzbinaid"));
                stavka.setRedniBroj(rs.getInt("s.rednibroj"));
                stavka.setKolicina(rs.getInt("s.kolicina"));
                stavka.setIznos(rs.getDouble("s.iznos"));
                Artikal a = new Artikal();
                a.setArtikalID(rs.getInt("a.artikalid"));
                a.setCenaBezporeza(rs.getDouble("a.cenabezporeza"));
                a.setNaziv(rs.getString("a.naziv"));
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
                stavka.setArtikal(a);
                ucitanaLista.add(stavka);
            }
        return ucitanaLista;
    }

    @Override
    public String getIdKlase() {
        return "narudzbinaid,redniBroj";
    }

    @Override
    public String getSpoljniKljucKlase() {
        return "narudzbinaid";
    }
    
    
}

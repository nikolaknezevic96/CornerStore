/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomocna;

import domain.InterfaceObjekat;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nikola
 */
public class PretragaNarudzbina implements InterfaceObjekat {
    int narudzbinaid;
    Date datum;
    String imePrezime;
    String stavke;
    String telefon;
    double ukupnaCena;

    public PretragaNarudzbina() {
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getStavke() {
        return stavke;
    }

    public void setStavke(String stavke) {
        this.stavke = stavke;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public int getNarudzbinaid() {
        return narudzbinaid;
    }

    public void setNarudzbinaid(int narudzbinaid) {
        this.narudzbinaid = narudzbinaid;
    }

    @Override
    public String vratiNazivTabele() {
        return "narudzbina";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return null;
    }

    @Override
    public ArrayList<InterfaceObjekat> ucitaj(ResultSet rs) throws Exception {
        ArrayList<InterfaceObjekat> lista = new ArrayList<>();
        while(rs.next()) {
                PretragaNarudzbina pn = new PretragaNarudzbina();
                pn.setDatum(rs.getDate("n.datum"));
                pn.setImePrezime(rs.getString("k.ime")+ " " + rs.getString("k.prezime"));
                pn.setNarudzbinaid(rs.getInt("n.narudzbinaid"));
                pn.setTelefon(rs.getString("k.telefon"));
                pn.setStavke(rs.getString("stavke"));
                pn.setUkupnaCena(rs.getDouble("n.ukupnaCena"));
                lista.add(pn);
                
            }
        return lista;
    }

    @Override
    public String getIdKlase() {
        return "narudzbinaid";
    }

    @Override
    public String getSpoljniKljucKlase() {
        return null;
    }
    
    
    
}

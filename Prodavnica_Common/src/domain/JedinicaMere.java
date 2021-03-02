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
public class JedinicaMere implements InterfaceObjekat{
    int JedinicaMereID;
    String naziv;

    public JedinicaMere() {
    }

    public JedinicaMere(int JedinicaMereID, String naziv) {
        this.JedinicaMereID = JedinicaMereID;
        this.naziv = naziv;
    }

    public int getJedinicaMereID() {
        return JedinicaMereID;
    }

    public void setJedinicaMereID(int JedinicaMereID) {
        this.JedinicaMereID = JedinicaMereID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiNazivTabele() {
        return "jedinicamere";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return JedinicaMereID+",'"+naziv;
    }

    @Override
    public ArrayList<InterfaceObjekat> ucitaj(ResultSet rs) throws Exception {
        ArrayList<InterfaceObjekat> lista = new ArrayList<>();
        while(rs.next()) {
                JedinicaMere j = new JedinicaMere();
                j.setJedinicaMereID(rs.getInt("jedinicamereid"));
                j.setNaziv(rs.getString("naziv"));
                lista.add(j);
            }
        return lista;
    }

    @Override
    public String getIdKlase() {
        return "JedinicaMereID";
    }

    @Override
    public String getSpoljniKljucKlase() {
        return null;
    }
    
    
}

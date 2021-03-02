/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nikola
 */
public interface InterfaceObjekat extends Serializable{
    
    public String vratiNazivTabele();

    public String vratiVrednostiZaInsert();

    public ArrayList<InterfaceObjekat> ucitaj(ResultSet rs) throws Exception;

    public String getIdKlase();
    public String getSpoljniKljucKlase();
}

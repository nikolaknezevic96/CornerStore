/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domain.Artikal;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class ModelTabeleArtikal extends AbstractTableModel{
    ArrayList<Artikal> lista;
    String[] kolone = {"Naziv", "Cena bez poreza", "Jedinica mere" ,"Poreska stopa"};

    public ModelTabeleArtikal() {
        lista = new ArrayList<>();
    }

    public ArrayList<Artikal> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Artikal> lista) {
        this.lista = lista;
    }
    
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column]; //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Artikal a = lista.get(rowIndex);
        
        switch(columnIndex) {
            case 0: return a.getNaziv();
            case 1: return a.getCenaBezporeza();
            case 2: return a.getJm().getNaziv();
            case 3: return a.getPs().getNaziv();
            default: return null;
        }
    }
    
    
}

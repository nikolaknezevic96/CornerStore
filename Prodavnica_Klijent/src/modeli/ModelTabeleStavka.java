/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domain.StavkaNarudzbine;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class ModelTabeleStavka extends AbstractTableModel{
    ArrayList<StavkaNarudzbine> lista;
    String[] kolone = {"Naziv","Jedinica mere","Kolicina","Jedinicna cena","Poreska stopa","Ukupna cena"};
    
    public ModelTabeleStavka() {
        lista = new ArrayList<>();
    }

    public ArrayList<StavkaNarudzbine> getLista() {
        return lista;
    }

    public void setLista(ArrayList<StavkaNarudzbine> lista) {
        this.lista = lista;
        fireTableDataChanged();
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
        return kolone[column];
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaNarudzbine s = lista.get(rowIndex);
        
        switch(columnIndex) {
            case 0: return s.getArtikal().getNaziv();
            case 1: return s.getArtikal().getJm().getNaziv();
            case 2: return s.getKolicina();
            case 3: return s.getArtikal().getCenaBezporeza();
            case 4: return s.getArtikal().getPs().getIznosStope();
            case 5: return s.getIznos();
            default: return null;
        }
    }
    
    public void dodaj(StavkaNarudzbine s) {
        lista.add(s);
        fireTableDataChanged();
    }
    
    public void obrisi(int row) {
        lista.remove(row);
        fireTableDataChanged();
    }
    
    public void osvezi() {
        fireTableDataChanged();
    }
}

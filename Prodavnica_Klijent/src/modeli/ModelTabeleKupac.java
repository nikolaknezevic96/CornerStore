/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domain.Kupac;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class ModelTabeleKupac extends AbstractTableModel {
    ArrayList<Kupac> lista;
    String[] kolone = {"Ime i prezime", "Telefon"};

    public ModelTabeleKupac() {
        lista = new ArrayList<>();
    }

    public ArrayList<Kupac> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Kupac> lista) {
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
        return kolone[column]; //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kupac k = lista.get(rowIndex);
        
        switch(columnIndex) {
            case 0: return k.getIme()+" "+k.getPrezime();
            case 1: return k.getTelefon();
            default: return null;
        }
    }
    
    public void dodaj(Kupac k) {
        lista.add(k);
        fireTableDataChanged();
    }
    
    public void obrisi(int red) {
        lista.remove(red);
        fireTableDataChanged();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import pomocna.PretragaNarudzbina;

/**
 *
 * @author Nikola
 */
public class ModelTabeleNarudzbina extends AbstractTableModel{
    String[] kolone = {"Datum","Ime i prezime kupca","Stavke narudzbine", "Telefon", "Ukupna cena"};
    ArrayList<PretragaNarudzbina> lista;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public ModelTabeleNarudzbina() {
        lista = new ArrayList<>();
    }

    public ArrayList<PretragaNarudzbina> getLista() {
        return lista;
    }

    public void setLista(ArrayList<PretragaNarudzbina> lista) {
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
        PretragaNarudzbina n = lista.get(rowIndex);
        
        switch(columnIndex) {
            case 0: return sdf.format(n.getDatum());
            case 1: return n.getImePrezime();
            case 2: return n.getStavke();
            case 3: return n.getTelefon();
            case 4: return n.getUkupnaCena();
            default: return null;
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domain.Artikal;
import domain.Kupac;
import domain.Narudzbina;
import domain.StavkaNarudzbine;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import konstante.Operacije;
import kontroler.KontrolerKI;
import modeli.ModelTabeleStavka;
import transfer.KlijentskiZahtev;

/**
 *
 * @author Nikola
 */
public class UnosNarudzbine extends javax.swing.JDialog {
    //Narudzbina n;
    /**
     * Creates new form UnosNarudzbine
     */
    public UnosNarudzbine(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        srediCMB();
        srediTabelu();
        this.setTitle("Unos narudžbine");
    }

   /* public Narudzbina getN() {
        return n;
    }

    public void setN(Narudzbina n) {
        this.n = n;
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblStavka = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cmbArtikal = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtKolicina = new javax.swing.JTextField();
        btnDodaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();
        btnNazad = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmbKupac = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblStavka.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblStavka);

        jLabel1.setText("Izaberite artikal: ");

        cmbArtikal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Kolicina:");

        btnDodaj.setText("Dodaj stavku");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi stavku");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        btnNazad.setText("Nazad");
        btnNazad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNazadActionPerformed(evt);
            }
        });

        jLabel2.setText("Izaberite kupca:");

        cmbKupac.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNazad, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbArtikal, 0, 152, Short.MAX_VALUE)
                            .addComponent(txtKolicina)
                            .addComponent(cmbKupac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(46, 46, 46)
                        .addComponent(btnDodaj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(btnObrisi)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbArtikal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbKupac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDodaj)
                    .addComponent(btnObrisi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnNazad))
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
       Artikal a = (Artikal) cmbArtikal.getSelectedItem();
       if(txtKolicina.getText().isEmpty()) {
           JOptionPane.showMessageDialog(this, "Unesite zeljenu kolicinu");
           return;
       }
       
       int kolicina = Integer.parseInt(txtKolicina.getText());
        StavkaNarudzbine s = new StavkaNarudzbine();
        s.setArtikal(a);
        s.setKolicina(kolicina);
        s.setNarudzbinaid(-1);
        s.setRedniBroj(-1);
        double iznos = (a.getCenaBezporeza()+a.getCenaBezporeza()*a.getPs().getIznosStope())*kolicina;
        s.setIznos(iznos);
        ModelTabeleStavka mts = (ModelTabeleStavka) tblStavka.getModel();
        mts.dodaj(s);
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        ModelTabeleStavka mts = (ModelTabeleStavka) tblStavka.getModel();
        mts.obrisi(tblStavka.getSelectedRow());
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnNazadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNazadActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnNazadActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        Date datum = new Date();
        ModelTabeleStavka mts = (ModelTabeleStavka) tblStavka.getModel();
        ArrayList<StavkaNarudzbine> listaStavki = mts.getLista();
        double ukupnaCena = 0;
        
        if(listaStavki.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Morate uneti bar jednu stavku");
            return;
        }
        
        for(StavkaNarudzbine s: listaStavki) {
            ukupnaCena += s.getIznos();
        }
        Kupac kupac = (Kupac) cmbKupac.getSelectedItem();
        Narudzbina n = new Narudzbina(-1, datum, ukupnaCena, kupac);
        n.setLista(listaStavki);
        /*KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.sacuvaj_narudzbinu);
        kz.setParametar(n);
        Komunikacija.getInstance().posaljiZahtev(kz);
        
        boolean uspesno = (boolean) Komunikacija.getInstance().primiOdgovor().getParametar();*/
        boolean uspesno = KontrolerKI.getInstance().sacuvajNarudzbinu(n);
        if(uspesno) {
            JOptionPane.showMessageDialog(this, "Uspesno sacuvana narudzbina");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Nije uspelo cuvanje narudzbine");
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UnosNarudzbine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UnosNarudzbine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UnosNarudzbine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UnosNarudzbine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UnosNarudzbine dialog = new UnosNarudzbine(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnNazad;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbArtikal;
    private javax.swing.JComboBox cmbKupac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStavka;
    private javax.swing.JTextField txtKolicina;
    // End of variables declaration//GEN-END:variables

    private void srediCMB() {
        /*KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.vrati_artikle);
        Komunikacija.getInstance().posaljiZahtev(kz);
        
        ArrayList<Artikal> lista = (ArrayList<Artikal>) Komunikacija.getInstance().primiOdgovor().getParametar();*/
        ArrayList<Artikal> lista = KontrolerKI.getInstance().vratiArtikle();
        cmbArtikal.removeAllItems();
        
        for(Artikal a: lista) {
            cmbArtikal.addItem(a);
        }
        
        /*KlijentskiZahtev kz1 = new KlijentskiZahtev();
        kz1.setOperacija(Operacije.vrati_kupce);
        String[] parametri = {"",""};
        kz1.setParametar(parametri);
        Komunikacija.getInstance().posaljiZahtev(kz1);
        
        ArrayList<Kupac> listaKupaca = (ArrayList<Kupac>) Komunikacija.getInstance().primiOdgovor().getParametar();*/
        String[] parametri = {"",""};
        ArrayList<Kupac> listaKupaca = KontrolerKI.getInstance().vratiKupce(parametri);
        cmbKupac.removeAllItems();
        
        for(Kupac k : listaKupaca) {
            cmbKupac.addItem(k);
        }
    }

    private void srediTabelu() {
        ModelTabeleStavka mts = new ModelTabeleStavka();
        tblStavka.setModel(mts);
    }
}

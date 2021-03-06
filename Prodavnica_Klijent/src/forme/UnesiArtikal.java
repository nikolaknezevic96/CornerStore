/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domain.Artikal;
import domain.JedinicaMere;
import domain.PoreskaStopa;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import konstante.Operacije;
import kontroler.KontrolerKI;
import modeli.ModelTabeleArtikal;
import transfer.KlijentskiZahtev;

/**
 *
 * @author Nikola
 */
public class UnesiArtikal extends javax.swing.JDialog {

    /**
     * Creates new form UnesiArtikal
     */
    public UnesiArtikal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        srediCMB();
        srediTabelu();
        this.setTitle("Forma za unos artikla");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbJm = new javax.swing.JComboBox();
        cmbPorez = new javax.swing.JComboBox();
        txtNaziv = new javax.swing.JTextField();
        txtCena = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnPotvrdi = new javax.swing.JButton();
        btnNazad = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblArtikli = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cmbJm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbPorez.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Naziv artikla:");

        jLabel2.setText("Cena bez poreza:");

        jLabel3.setText("Jedinica mere:");

        jLabel4.setText("Porez:");

        btnPotvrdi.setText("Potvrdi");
        btnPotvrdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPotvrdiActionPerformed(evt);
            }
        });

        btnNazad.setText("Nazad");
        btnNazad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNazadActionPerformed(evt);
            }
        });

        tblArtikli.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblArtikli);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNaziv)
                            .addComponent(txtCena)
                            .addComponent(cmbJm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbPorez, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnPotvrdi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNazad)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbJm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbPorez, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPotvrdi)
                    .addComponent(btnNazad))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNazadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNazadActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnNazadActionPerformed

    private void btnPotvrdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPotvrdiActionPerformed
        String naziv = txtNaziv.getText();
        String cenaTxt = txtCena.getText();
        JedinicaMere jm = (JedinicaMere) cmbJm.getSelectedItem();
        PoreskaStopa ps = (PoreskaStopa) cmbPorez.getSelectedItem();
        if(naziv.isEmpty() || cenaTxt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Unesite sva polja");
            return;
        }
        double cena = 0;
        try {
            cena = Double.parseDouble(cenaTxt);
        } catch(NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Cena mora biti realan broj");
            return;
        }
        
        ModelTabeleArtikal mta = (ModelTabeleArtikal) tblArtikli.getModel();
        ArrayList<Artikal> lista = mta.getLista();
        
        for(Artikal a: lista) {
            if(a.getNaziv().equals(naziv)) {
                JOptionPane.showMessageDialog(this, "Artikal sa unetim nazivom vec postoji u bazi");
                return;
            }
        }
        Artikal a = new Artikal(-1, naziv, cena, ps, jm);
        /*KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.sacuvaj_artikal);
        kz.setParametar(a);
        Komunikacija.getInstance().posaljiZahtev(kz);
        
        boolean uspesno = (boolean) Komunikacija.getInstance().primiOdgovor().getParametar();*/
        boolean uspesno = KontrolerKI.getInstance().sacuvajArtikal(a);
        
        if(uspesno) {
            JOptionPane.showMessageDialog(this, "Uspesno unet novi artikal");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Neuspesan unos novog artikla");
        }
        
    }//GEN-LAST:event_btnPotvrdiActionPerformed

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
            java.util.logging.Logger.getLogger(UnesiArtikal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UnesiArtikal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UnesiArtikal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UnesiArtikal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UnesiArtikal dialog = new UnesiArtikal(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnNazad;
    private javax.swing.JButton btnPotvrdi;
    private javax.swing.JComboBox cmbJm;
    private javax.swing.JComboBox cmbPorez;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblArtikli;
    private javax.swing.JTextField txtCena;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    private void srediCMB() {
        /*KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.vrati_jedinice_mere);
        Komunikacija.getInstance().posaljiZahtev(kz);
        
        ArrayList<JedinicaMere> lista = (ArrayList<JedinicaMere>) Komunikacija.getInstance().primiOdgovor().getParametar();*/
        ArrayList<JedinicaMere> lista = KontrolerKI.getInstance().vratiJediniceMere();
        cmbJm.removeAllItems();
        
        for(JedinicaMere jm: lista) {
            cmbJm.addItem(jm);
        }
        
        /*KlijentskiZahtev kz1 = new KlijentskiZahtev();
        kz1.setOperacija(Operacije.vrati_poreze);
        Komunikacija.getInstance().posaljiZahtev(kz1);
        
        ArrayList<PoreskaStopa> listaKupaca = (ArrayList<PoreskaStopa>) Komunikacija.getInstance().primiOdgovor().getParametar();*/
        ArrayList<PoreskaStopa> listaPoreza = KontrolerKI.getInstance().vratiPoreze();
        cmbPorez.removeAllItems();
        
        for(PoreskaStopa p : listaPoreza) {
            cmbPorez.addItem(p);
        }
    }

    private void srediTabelu() {
        ModelTabeleArtikal mta = new ModelTabeleArtikal();
        /*KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.vrati_artikle);
        Komunikacija.getInstance().posaljiZahtev(kz);
        
        ArrayList<Artikal> lista = (ArrayList<Artikal>) Komunikacija.getInstance().primiOdgovor().getParametar();*/
        ArrayList<Artikal> lista = KontrolerKI.getInstance().vratiArtikle();
        mta.setLista(lista);
        tblArtikli.setModel(mta);
    }
}

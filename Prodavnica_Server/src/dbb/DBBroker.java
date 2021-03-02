/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbb;

import domain.Artikal;
import domain.InterfaceObjekat;
import domain.JedinicaMere;
import domain.Kupac;
import domain.Narudzbina;
import domain.PoreskaStopa;
import domain.StavkaNarudzbine;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pomocna.PretragaNarudzbina;

/**
 *
 * @author Nikola
 */
public class DBBroker {
    private static DBBroker instance;
    private Connection connection;
    
    private DBBroker() {
        try {
            ucitajDriver();
            otvoriKonekciju();
        } catch (Exception ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static DBBroker getInstance() {
        if(instance == null)
            instance = new DBBroker();
        return instance;
    }

    /*public ArrayList<Kupac> vratiKupce(String[] parametri) {
        ArrayList<Kupac> lista = new ArrayList<>();
        String dodatak = "";
        if(!parametri[0].equals("")) {
            dodatak += " and ime = '" + parametri[0] + "'";
        }
        if(!parametri[1].equals("")) {
            dodatak += " and prezime = '" + parametri[1] + "'";
        }
        String sql = "select * from kupac where 1=1" + dodatak;
        
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()) {
                Kupac k = new Kupac();
                k.setIme(rs.getString("ime"));
                k.setPrezime(rs.getString("prezime"));
                k.setKupacid(rs.getInt("kupacid"));
                k.setTelefon(rs.getString("telefon"));
                lista.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }*/

    /*public ArrayList<PretragaNarudzbina> vratiNarudzbine(String[] parametri) {
        String dodatak = "";
        ArrayList<PretragaNarudzbina> lista = new ArrayList<>();
        if(!parametri[0].equals("")) {
            dodatak += "and n.datum = '" + parametri[0] + "'";
        }
        
        if(!parametri[1].equals("")) {
            dodatak += "and n.kupacid = "+ parametri[1];
        }
        String sql = "select n.NarudzbinaID,n.datum,k.ime,k.prezime,k.telefon, GROUP_CONCAT(concat(a.naziv,':'),concat(s.kolicina,' ',j.naziv) SEPARATOR ' , ') as stavke,n.ukupnaCena from Narudzbina n join stavkanarudzbine s on n.NarudzbinaID=s.NarudzbinaID join kupac k on n.kupacID=k.kupacID join artikal a on s.ArtikalID = a.ArtikalID join jedinicamere j on j.JedinicaMereID=a.JedinicaMereID where 1=1 "+dodatak+" group by n.NarudzbinaID";
;
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
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
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
       return lista;
    }*/

    /*public ArrayList<Artikal> vratiArtikle() {
        ArrayList<Artikal> lista = new ArrayList<>();
        String sql = "select * from artikal a join JedinicaMere j on a.JedinicaMereID=j.JedinicaMereID join poreskastopa p on a.PoreskaStopaID=p.PoreskaStopaID";
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()) {
                Artikal a = new Artikal();
                a.setArtikalID(rs.getInt("a.artikalid"));
                a.setCenaBezporeza(rs.getDouble("a.cenabezporeza"));
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
                lista.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }*/

    /*public boolean sacuvajNarudzbinu(Narudzbina n) {
        String sql = "insert into narudzbina values (?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            int id = vratiMaxIdNarudzbina();
            ps.setInt(1, id);
            ps.setDate(2, new java.sql.Date(n.getDatum().getTime()));
            ps.setDouble(3, n.getUkupnaCena());
            ps.setInt(4, n.getKupac().getKupacid());
            
            for(StavkaNarudzbine s : n.getLista()) {
                
                String upit = "insert into stavkanarudzbine values(?,?,?,?,?)";
                PreparedStatement ss = connection.prepareStatement(upit);
                ss.setInt(1, id);
                ss.setInt(2, vratiMaxRbStavka());
                ss.setInt(3, s.getKolicina());
                ss.setDouble(4, s.getIznos());
                ss.setInt(5, s.getArtikal().getArtikalID());
                ss.executeUpdate();
                
            }
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }*/
    
    public int vratiMaxIdNarudzbina() {
        int id = 0;
        String sql = "select max(narudzbinaid) as max from narudzbina";
        try {
            Statement s = connection.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()) {
                id = rs.getInt("max");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ++id;
    }
    
    public int vratiMaxRbStavka() {
        int id = 0;
        String sql = "select max(rednibroj) as max from stavkanarudzbine";
        try {
            Statement s = connection.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()) {
                id = rs.getInt("max");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ++id;
    }

    /*public Narudzbina vratiOdredjenuNarudzbinu(String[] parametri2) {
        Narudzbina n = new Narudzbina();
        ArrayList<StavkaNarudzbine> lista = new ArrayList<>();
        String dodatak = "";
        if(!parametri2[0].equals("")) {
            dodatak = " and a.naziv = '" + parametri2[0] + "'";
        }
        String sql = "select * from narudzbina n join kupac k on n.kupacID=k.kupacID where NarudzbinaID=" + parametri2[1];
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()) {
                n.setNarudzbinaid(rs.getInt("narudzbinaid"));
                n.setDatum(rs.getDate("datum"));
                n.setUkupnaCena(rs.getDouble("ukupnacena"));
                Kupac k = new Kupac();
                k.setKupacid(rs.getInt("kupacid"));
                k.setIme(rs.getString("ime"));
                k.setPrezime(rs.getString("prezime"));
                k.setTelefon(rs.getString("telefon"));
                n.setKupac(k);
            }
            String sql1 = "select * from stavkanarudzbine s join artikal a on s.ArtikalID=a.ArtikalID join jedinicamere j on a.JedinicaMereID=j.JedinicaMereID join poreskastopa p on a.PoreskaStopaID=p.PoreskaStopaID where s.NarudzbinaID= " + parametri2[1] + dodatak;
            Statement s1 = connection.createStatement();
            ResultSet rs1 = s1.executeQuery(sql1);
            while(rs1.next()) {
                StavkaNarudzbine stavka = new StavkaNarudzbine();
                stavka.setNarudzbinaid(rs1.getInt("s.narudzbinaid"));
                stavka.setRedniBroj(rs1.getInt("s.rednibroj"));
                stavka.setKolicina(rs1.getInt("s.kolicina"));
                stavka.setIznos(rs1.getDouble("s.iznos"));
                Artikal a = new Artikal();
                a.setArtikalID(rs1.getInt("a.artikalid"));
                a.setCenaBezporeza(rs1.getDouble("a.cenabezporeza"));
                a.setNaziv(rs1.getString("a.naziv"));
                JedinicaMere jm = new JedinicaMere();
                jm.setJedinicaMereID(rs1.getInt("j.jedinicamereid"));
                jm.setNaziv(rs1.getString("j.naziv"));
                a.setJm(jm);
                a.setNaziv(rs1.getString("a.naziv"));
                PoreskaStopa ps = new PoreskaStopa();
                ps.setPoreskastopaid(rs1.getInt("p.poreskastopaid"));
                ps.setNaziv(rs1.getString("p.naziv"));
                ps.setIznosStope(rs1.getDouble("iznosstope"));
                a.setPs(ps);
                stavka.setArtikal(a);
                lista.add(stavka);
            }
            n.setLista(lista);
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }*/

    /*public boolean izmeniNarudzbinu(Narudzbina n1) {
        String sql = "update narudzbina set datum = ?, ukupnaCena = ? where narudzbinaid = " + n1.getNarudzbinaid();
        ocistiStavke(n1.getNarudzbinaid());
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(n1.getDatum().getTime()));
            ps.setDouble(2, n1.getUkupnaCena());
            for(StavkaNarudzbine s : n1.getLista()) {
                
                String upit = "insert into stavkanarudzbine values(?,?,?,?,?)";
                PreparedStatement ss = connection.prepareStatement(upit);
                ss.setInt(1, n1.getNarudzbinaid());
                ss.setInt(2, vratiMaxRbStavka());
                ss.setInt(3, s.getKolicina());
                ss.setDouble(4, s.getIznos());
                ss.setInt(5, s.getArtikal().getArtikalID());
                ss.executeUpdate();
                
            }
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }*/

    private void ocistiStavke(int narudzbinaID) {
        String sql = "delete from stavkanarudzbine where narudzbinaid = " + narudzbinaID;
        try {
            Statement s = connection.prepareStatement(sql);
            s.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*public boolean obrisiNarudzbinu(int id) {
        String sql = "delete from narudzbina where narudzbinaid =" + id;
        ocistiStavke(id);
        try {
            Statement s = connection.createStatement();
            s.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }*/

    /*public boolean unesiKupca(Kupac k) {
        String sql = "insert into kupac values (?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, vratiMaxIdKupac());
            ps.setString(2, k.getIme());
            ps.setString(3, k.getPrezime());
            ps.setString(4, k.getTelefon());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }*/
    
    private int vratiMaxIdKupac() {
        int id = 0;
        String sql = "select max(kupacid) as max from kupac";
        try {
            Statement s = connection.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()) {
                id = rs.getInt("max");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ++id;
    }

    /*public boolean izmeniKupca(Kupac k) {
       String sql = "update kupac set ime = ?,prezime = ?,telefon = ? where kupacid = " + k.getKupacid();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, k.getIme());
            ps.setString(2, k.getPrezime());
            ps.setString(3, k.getTelefon());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }*/

    /*public boolean obrisiKupca(int kupacID) {
        String sql = "delete from kupac where kupacid = " + kupacID;
        try {
            Statement s = connection.createStatement();
            s.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }*/

    /*public ArrayList<JedinicaMere> vratiJM() {
        ArrayList<JedinicaMere> lista = new ArrayList<>();
        String sql = "select * from jedinicamere";
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()) {
                JedinicaMere j = new JedinicaMere();
                j.setJedinicaMereID(rs.getInt("jedinicamereid"));
                j.setNaziv(rs.getString("naziv"));
                lista.add(j);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }*/

    /*public ArrayList<PoreskaStopa> vratiPS() {
        ArrayList<PoreskaStopa> lista = new ArrayList<>();
        String sql = "select * from poreskastopa";
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()) {
                PoreskaStopa p = new PoreskaStopa();
                p.setPoreskastopaid(rs.getInt("poreskastopaid"));
                p.setNaziv(rs.getString("naziv"));
                p.setIznosStope(rs.getDouble("iznosstope"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }*/

    /*public boolean sacuvajArtikal(Artikal a) {
        String sql = "insert into artikal values (?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, vratiMaxIdArtikal());
            ps.setString(2, a.getNaziv());
            ps.setDouble(3, a.getCenaBezporeza());
            ps.setInt(4, a.getPs().getPoreskastopaid());
            ps.setInt(5, a.getJm().getJedinicaMereID());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }*/
    
    public int vratiMaxIdArtikal() {
        int id = 0;
        String sql = "select max(artikalid) as max from artikal";
        try {
            Statement s = connection.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()) {
                id = rs.getInt("max");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ++id;
    }

    private void ucitajDriver() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
    }

    public void otvoriKonekciju() throws Exception {
        String url = "jdbc:mysql://localhost:3306/prodavnica";
        try {
            connection = DriverManager.getConnection(url,"root", "");
            connection.setAutoCommit(false);
            
        } catch (SQLException ex) {
            throw new Exception("Neuspesno otvaranje konekcije!", ex);
        }
    }
    
    public void commit() throws Exception {
        try {
            connection.commit();
        } catch (SQLException ex) {
            throw new Exception("Neuspesan commit transakcije!", ex);
        }
    }

    public void rollback() throws Exception {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            throw new Exception("Neuspesan rollback transakcije!", ex);
        }
    }

    public void zatvoriKonekciju() throws Exception {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new Exception("Neuspesno zatvaranje konekcije!", ex);
        }
    }
    
    public boolean sacuvaj(InterfaceObjekat io) throws Exception {
        
        try {
            String sql = "INSERT INTO " + io.vratiNazivTabele() + " VALUES (" + io.vratiVrednostiZaInsert() + ")";
            System.out.println(sql);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            return true;
        } 
                catch (Exception ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Neuspesno cuvanje objekta!", ex);
        }

    }
    
    public ArrayList<InterfaceObjekat> vrati(InterfaceObjekat io, String sql) throws Exception {
        try {
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            return io.ucitaj(rs);
        } catch (Exception ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Neuspesno ucitavanje objekata!", ex);
        }
    }
    
    
   public boolean izmeni(InterfaceObjekat io) throws Exception {
        if(io.vratiNazivTabele().equals("kupac")) {
        String sql = "update " + io.vratiNazivTabele() + " set ime = ?,prezime = ?,telefon = ? where kupacid = " + ((Kupac)io).getKupacid();
        try {
            Kupac k = (Kupac)io;
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, k.getIme());
            ps.setString(2, k.getPrezime());
            ps.setString(3, k.getTelefon());
            ps.executeUpdate();
            return true;
        }
        catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        if(io.vratiNazivTabele().equals("narudzbina")) {
        String sql = "update " + io.vratiNazivTabele() + " set datum = ?, ukupnaCena = ? where narudzbinaid = " + ((Narudzbina)io).getNarudzbinaid();
        
        try {
            Narudzbina n = (Narudzbina)io;
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(n.getDatum().getTime()));
            ps.setDouble(2, n.getUkupnaCena());
            for(StavkaNarudzbine s : n.getLista()) {
                
                String upit = "INSERT INTO stavkanarudzbine (NarudzbinaID,redniBroj,kolicina,iznos,ArtikalID) VALUES(?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE kolicina = ?, iznos = ?, ArtikalID = ?";
                PreparedStatement ss = connection.prepareStatement(upit);
                ss.setInt(1, s.getNarudzbinaid());
                ss.setInt(2, s.getRedniBroj());
                ss.setInt(3, s.getKolicina());
                ss.setDouble(4, s.getIznos());
                ss.setInt(5, s.getArtikal().getArtikalID());
                ss.setInt(6, s.getKolicina());
                ss.setDouble(7, s.getIznos());
                ss.setInt(8, s.getArtikal().getArtikalID());
                ss.executeUpdate();
                
            }
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        }
        
    return false;
}
   
   public void obrisi(InterfaceObjekat io, int id) {
       String sql = "delete from " + io.vratiNazivTabele() + " where " + io.getIdKlase()+ "="+id;
       
       if(io.vratiNazivTabele().equals("narudzbina")) {
       ocistiStavke(id);
       }
        try {
            Statement s = connection.createStatement();
            s.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
}

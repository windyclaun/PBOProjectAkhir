package DAO;
import java.sql.*;
import java.util.*;
import DAOImplement.DataImplement;
import Koneksi.Connector;
import Model.DataMobil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DataMobilDAO implements DataImplement{
    Connection con;

    final String select = "SELECT * FROM data_mobil";
    final String insert = "INSERT INTO data_mobil (nama,nomor_plat,merk,tahun,harga) VALUES (?,?,?,?,?)";
    final String update = "UPDATE data_mobil set nama=?,merk=?,tahun=?,harga=? where nomor_plat=?";
    final String delete = "DELETE FROM data_mobil where nomor_plat=?";
    public DataMobilDAO(){
        con = Connector.connection();
    }

    public void insert(DataMobil dm) {
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dm.getNama());
            ps.setString(2, dm.getNomor_plat());
            ps.setString(3, dm.getMerk());
            ps.setInt(4, dm.getTahun());
            ps.setInt(5, dm.getHarga());
            ps.executeUpdate();
            throw new SQLException("Sukses Membeli Mobil " + dm.getMerk() + " " + dm.getNama());
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void update(DataMobil dm) {
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(update);
            ps.setString(1, dm.getNama());
            ps.setString(5, dm.getNomor_plat());
            ps.setString(2, dm.getMerk());
            ps.setInt(3, dm.getTahun());
            ps.setInt(4, dm.getHarga());
            ps.executeUpdate();
            throw new SQLException("Data Mobil " + dm.getMerk()+ " " + dm.getNama() + " Diupdate");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void delete(String nomor_plat) {
        PreparedStatement ps = null;
        try{
            //hapus harga berdasarkan nomor plat
            ps = con.prepareStatement(delete);
            ps.setString(1, nomor_plat);
            ps.executeUpdate();
            throw new SQLException("Mobil Dijual");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public List<DataMobil> getAll(){
        List<DataMobil> ld = null;
        try{
            ld = new ArrayList<DataMobil>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                DataMobil dm = new DataMobil();
                dm.setNama(rs.getString("nama"));
                dm.setNomor_plat(rs.getString("nomor_plat"));
                dm.setMerk(rs.getString("merk"));
                dm.setTahun(rs.getInt("tahun"));
                dm.setHarga(rs.getInt("harga"));
                ld.add(dm);
                if(rs.getString("nama") == ""){
                    JOptionPane.showMessageDialog(null, "Miskin");
                }
            }
        }catch(SQLException ex){
            Logger.getLogger(DataMobilDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ld;
    }
}

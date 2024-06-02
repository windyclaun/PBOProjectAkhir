package Koneksi;
import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;   


public class Connector {
    static Connection con;

    public static Connection connection() {
        if (con == null) {
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("garasi_db");
            data.setUser("root");
            data.setPassword("");
            try {
                con = data.getConnection();
                System.out.println("Koneksi Berhasil");
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Koneksi Gagal");
            }
        }
        return con;
    }
}

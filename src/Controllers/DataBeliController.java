package Controllers;
import java.util.List;
import DAO.DataMobilDAO;
import DAOImplement.DataImplement;
import Model.*;
import Model.ModelTabelMobil;
import View.*;


public class DataBeliController {
    MenuBeli frame;
    DataMobilDAO implement;
    List<DataMobil> list;

    public DataBeliController(MenuBeli frame){
        this.frame = frame;
        implement = new DataMobilDAO();
        list = implement.getAll();
    }

    public void insert(){
        DataMobil dm = new DataMobil();
        int ttahun = Integer.parseInt(frame.getJttahun().getText());
        int tharga = Integer.parseInt(frame.getJtharga().getText());
        dm.setNama(frame.getJtnama().getText());
        dm.setNomor_plat(frame.getJtnomor_plat().getText());
        dm.setMerk(frame.getJtmerk().getText());
        dm.setTahun(ttahun);
        dm.setHarga(tharga);
        implement.insert(dm);
    }
}

package Controllers;
import java.util.List;
import DAO.DataMobilDAO;
import DAOImplement.DataImplement;
import Model.DataMobil;
import Model.ModelTabelMobil;
import View.*;


public class DataMobilController {
    MenuMobil frame;
    MenuBeli fr;
    DataMobilDAO implement;
    List<DataMobil> list;

    public DataMobilController(MenuMobil frame){
        this.frame = frame;
        implement = new DataMobilDAO();
        list = implement.getAll();
    }

    public void isiTabel(){
        list = implement.getAll();
        ModelTabelMobil mtm = new ModelTabelMobil(list);
        frame.getTabeldata().setModel(mtm);
    }

    public void update(){
        DataMobil dm = new DataMobil();
        int ttahun = Integer.parseInt(frame.getJttahun().getText());
        int tharga = Integer.parseInt(frame.getJtharga().getText());
        dm.setNama(frame.getJtnama().getText());
        dm.setNomor_plat(frame.getJtnomor_plat().getText());
        dm.setMerk(frame.getJtmerk().getText());
        dm.setTahun(ttahun);
        dm.setHarga(tharga);
        implement.update(dm);
    }

    public void delete(){
        String np = frame.getJtnomor_plat().getText();
        implement.delete(np);
    }
}

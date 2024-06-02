package DAOImplement;
import java.util.List;
import Model.DataMobil;

public interface DataImplement {
    public void insert(DataMobil dm);
    public void update(DataMobil dm);
    public void delete(String nomor_plat);
    public List<DataMobil> getAll();
}

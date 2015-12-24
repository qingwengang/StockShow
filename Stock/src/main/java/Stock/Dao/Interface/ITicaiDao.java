package Stock.Dao.Interface;

import Stock.Entity.Ticai;

import java.util.List;

/**
 * Created by wgqing on 2015/12/22.
 */
public interface ITicaiDao {
    void AddTicai(Ticai tc);
    List<Ticai> Query(String sql);
}

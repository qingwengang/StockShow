package Stock.Dao.MongoDao;

import Stock.Dao.MongoInterface.IFiveDangMDao;
import Stock.Entity.Mongo.FiveDangM;
import Util.MongoUtil;
import com.mongodb.Mongo;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 * Created by wgqing on 2015/11/26.
 */
public class FiveDangMDao implements IFiveDangMDao {
    @Override
    public void Add(FiveDangM fiveDangM) {
        Mongo m= MongoUtil.getMongo();
        Morphia morphia=new Morphia();
        Datastore ds=morphia.createDatastore(m,"TV");
        ds.save(fiveDangM);
    }
}

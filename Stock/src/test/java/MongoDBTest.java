import Stock.Entity.FiveDangPrice;
import Stock.Entity.Mongo.FiveDangM;
import Stock.Entity.Mongo.FiveDangPriceM;
import Util.MongoUtil;
import com.mongodb.Mongo;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 * Created by wgqing on 2015/11/9.
 */
public class MongoDBTest {
    public static void main(String[] args) throws Exception{
        Mongo m= MongoUtil.getMongo();
        Morphia morphia=new Morphia();
        Datastore ds=morphia.createDatastore(m,"TV");
        FiveDangM dangM=new FiveDangM();
        dangM.setLastClosePrice(32);
        FiveDangPriceM price=new FiveDangPriceM();
        price.setDealCount(111);
        dangM.getPrices().add(price);
        ds.save(dangM);
    }
}


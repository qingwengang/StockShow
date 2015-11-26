import Stock.Entity.Mongo.FiveDangM;
import com.mongodb.Mongo;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 * Created by wgqing on 2015/11/9.
 */
public class MongoDBTest {
    public static void main(String[] args) throws Exception{
       Mongo m=new Mongo("localhost",27017);
       Morphia morphia=new Morphia();
        Datastore ds=morphia.createDatastore(m,"TV");
        FiveDangM dangM=new FiveDangM();

        ds.save(dangM);
    }
}


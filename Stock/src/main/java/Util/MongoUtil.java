package Util;

import com.mongodb.Mongo;
import com.mongodb.MongoException;
import org.apache.log4j.Logger;

import java.net.UnknownHostException;

/**
 * Created by wgqing on 2015/11/26.
 */
public class MongoUtil {
    private static Logger logger = Logger.getLogger(MongoUtil.class);
    private static final int port = 27017;
    private static final String host = "localhost";
    private static Mongo mongo = null;
    public static Mongo getMongo() {
        if (mongo == null) {
            try {
                mongo = new Mongo(host, port);
            } catch (UnknownHostException | MongoException e) {
                logger.error("MongoUtil getMongo:"+e);
            }
        }
        return mongo;
    }
}

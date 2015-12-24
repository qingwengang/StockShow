package Stock.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created by wgqing on 2015/12/22.
 */
@Entity
public class TicaiStockRelation {
    public TicaiStockRelation() {
    }
    private int Id;
    private int TicaiId;
    private String StockCode;
    private int Status;
    private int Level;
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public int getTicaiId() {
        return TicaiId;
    }
    public void setTicaiId(int ticaiId) {
        TicaiId = ticaiId;
    }
    public int getStatus() {
        return Status;
    }
    public void setStatus(int status) {
        Status = status;
    }
    public String getStockCode() {
        return StockCode;
    }
    public void setStockCode(String stockCode) {
        StockCode = stockCode;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }
}

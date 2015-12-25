package Stock.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created by wgqing on 2015/12/22.
 */
@Entity
public class Ticai {
    public Ticai() {
    }
    private int Id;
    private String Name;
    private int Status;
    private int TicaiType;
    private String Url;
    private int OrderType;
    private String TypeName;
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public int getStatus() {
        return Status;
    }
    public void setStatus(int status) {
        Status = status;
    }

    public int getTicaiType() {
        return TicaiType;
    }

    public void setTicaiType(int ticaiType) {
        TicaiType = ticaiType;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public int getOrderType() {
        return OrderType;
    }

    public void setOrderType(int orderType) {
        OrderType = orderType;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String typeName) {
        TypeName = typeName;
    }
}

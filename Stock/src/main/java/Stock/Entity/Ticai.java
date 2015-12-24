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
}

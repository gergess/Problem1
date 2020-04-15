package sheridan.gergess.problem1.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "monitors")
public class MonitorEntity implements Serializable {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name = "";

    @Column(name = "inches")
    private int inches = 0;

    @Column(name = "refreshRate")
    private int refreshRate = 0;


    public MonitorEntity(){
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInches() {
        return inches;
    }

    public void setInches(int inches) {
        this.inches = inches;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }
}

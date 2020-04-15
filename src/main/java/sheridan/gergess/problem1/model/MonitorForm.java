package sheridan.gergess.problem1.model;

import javax.validation.constraints.*;
import java.io.Serializable;

public class MonitorForm implements Serializable {

    private int id = 0;

    @NotBlank
    @Size(max = 30)
    @Pattern(regexp = "[A-Za-z]*")
    private String name = "";

    @NotBlank
    @Size(max = 30)
    private int inches = 0;

    @NotBlank
    private int refreshRate = 0;


    public MonitorForm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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


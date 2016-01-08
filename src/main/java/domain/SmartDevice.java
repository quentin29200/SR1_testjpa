package domain;

import javax.persistence.*;

public abstract class SmartDevice {

    private int id;
    private float conso;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getConso() {
        return conso;
    }

    public void setConso(float conso) {
        this.conso = conso;
    }
}

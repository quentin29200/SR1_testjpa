package domain;

import javax.persistence.*;

@Entity
public class Heater extends SmartDevice {
    @Id
    @GeneratedValue
    private int id;
    private float conso;

}

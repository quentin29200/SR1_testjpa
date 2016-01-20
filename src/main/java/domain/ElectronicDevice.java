package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ElectronicDevice extends SmartDevice {
    @Id
    @GeneratedValue
    private int id;
    private float conso;

}

package org.egdeveloper.data.entities;

import org.egdeveloper.attributes.DisplayName;
import org.egdeveloper.attributes.EntityID;
import org.egdeveloper.attributes.MedTest;
import org.egdeveloper.attributes.StatVariable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table
@MedTest
@EntityID("titrationTest")
@DisplayName("Титриметрия")
public class TitrationTest extends MedicalTest {

    public TitrationTest(){}

    @Column(name = "oxalate")
    @NotNull
    @DisplayName("Оксалат")
    @StatVariable
    private double oxalate;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Patient patient;

    @DisplayName("Оксалат")
    @StatVariable
    public double getOxalate() {
        return oxalate;
    }

    public void setOxalate(double oxalate) {
        this.oxalate = oxalate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}

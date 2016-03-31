package org.egdeveloper.data.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.egdeveloper.attributes.DisplayName;
import org.egdeveloper.attributes.EntityID;
import org.egdeveloper.attributes.MedTest;
import org.egdeveloper.converters.CustomDateTimeDeserializer;
import org.egdeveloper.converters.CustomDateTimeSerializer;
import org.egdeveloper.data.entities.custom_types.Attachment;
import org.egdeveloper.data.entities.custom_types.PatientState;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@MedTest
@MappedSuperclass
@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
public abstract class MedicalTest extends AbstractEntity implements Serializable, Comparable<MedicalTest>{

    public MedicalTest(){
        attachment = new HashSet<>();
    }

    @NotNull
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(name = "testDate")
    @DisplayName("Дата проведения анализа")
    private LocalDate testDate;

    @NotNull
    @Column(name = "description")
    @DisplayName("Дополнительная информация")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "patientState")
    @DisplayName("Состояние пациента")
    private PatientState patientState;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "TestAttachments", joinColumns = @JoinColumn(name = "testID"))
    @Fetch(FetchMode.SELECT)
    private Set<Attachment> attachment;

    /**
     * Retrieve defined test date
     * @return test date
     */
    public LocalDate getTestDate(){
        return this.testDate;
    }

    /**
     * Set test date
     * @param testDate test date
     */
    public void setTestDate(LocalDate testDate){
        this.testDate = testDate;
    }

    /**
     * Retrieve test description
     * @return description
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Set description
     * @param description description
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     * Get patient state
     * @return patient state
     */
    public PatientState getPatientState(){
        return patientState;
    }

    /**
     * Set patient state
     * @param patientState patient state
     */
    public void setPatientState(PatientState patientState){
        this.patientState = patientState;
    }

    /**
     * Get test attachment
     * @return test attachment
     */
    @JsonProperty("attachments")
    public Set<Attachment> getAttachment(){
        return attachment;
    }

    /**
     * Set test attachment
     * @param attachment attachment
     */
    @JsonProperty("attachments")
    public void setAttachment(Set<Attachment> attachment){
        this.attachment = attachment;
    }

    /**
     * Retrieve name (type) of current test
     * @return test name (type)
     */
    @Transient
    public String retrieveName(){
        return this.getClass().getAnnotation(DisplayName.class).value();
    }

    @Transient
    public String retrieveEntityID(){
        return this.getClass().getAnnotation(EntityID.class).value();
    }

    @Override
    @Transient
    public int compareTo(MedicalTest otherTest){
        if(this.getTestDate().isEqual(otherTest.getTestDate()))
            return 0;
        else
            return this.getTestDate().isBefore(otherTest.getTestDate()) ? -1 : 1;
    }
}

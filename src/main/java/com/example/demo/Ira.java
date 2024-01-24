/*Setting up the model. This data will be stored in database*/
package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import lombok.Data;
//import lombok.NoArgsConstructor;

@Entity
@Table(name = "Ira")
public class Ira {
    
    //Make it primary key in DB
    @Id
    @Column(name = "ira_id", length = 5)
    //Auto increment
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int iraId;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "ira_name", length = 50)
    private String iraName;

    @Column(name = "ira_type", length = 50)
    private String iraType;

    public Ira(int iraId, String firstName, String lastName, String iraName, String iraType) {
        this.iraId = iraId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.iraName = iraName;
        this.iraType = iraType;
    }
    
    public Ira() {

    }

    public Ira(String firstName2, String lastName2, String iraName2, String iraType2) {
        this.firstName = firstName2;
        this.lastName = lastName2;
        this.iraName = iraName2;
        this.iraType = iraType2;
    }

    public int getIraId() {
        return iraId;
    }

    public void setIraId(int iraId) {
        this.iraId = iraId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIraName() {
        return iraName;
    }

    public void setIraName(String iraName) {
        this.iraName = iraName;
    }

    public String getIraType() {
        return iraType;
    }

    public void setIraType(String iraType) {
        this.iraType = iraType;
    }

    @Override
    public String toString(){
        return "Ira{" +
        "iraId=" + iraId +
        ", employeeName='" + firstName + " "+ lastName + '\\' +
        ", iraName='" + iraName + '\\' +
        ", iraType='" + iraType + 
        '}';
    }

}

package com.edu.unipiloto.testws.entidad;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Maria
 */
@XmlRootElement(name = "persona")
@XmlType(propOrder = {"id", "fullName", "age", "salary"})
public class Person {

    private int id;
    private String fullName;
    private int age;
    private double salary;
    
    public Person() {
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    @XmlElement
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    @XmlElement
    public double getSalary() {
        return salary;
    }

    public void setSalary() {
        double salarioBase = 13000000 / 3;
        double salarioCalculado = this.age * salarioBase;
        this.salary = salarioCalculado;
        
    }

}

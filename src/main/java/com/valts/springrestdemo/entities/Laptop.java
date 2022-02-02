package com.valts.springrestdemo.entities;

import javax.persistence.*;

@Entity
@Table(name = "laptops")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String modelName;

    public Laptop() {
    }

    public Laptop(Long id, String modelName) {
        this.id = id;
        this.modelName = modelName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                '}';
    }
}

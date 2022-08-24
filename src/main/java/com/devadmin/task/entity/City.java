package com.devadmin.task.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "city")
public class City implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String name;
    private int countryCode;
    @Column(nullable = false)
    private String district;
    private long population;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,countryCode,district,population);
    }
}

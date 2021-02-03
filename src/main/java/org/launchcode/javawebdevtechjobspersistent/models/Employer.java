package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Employer extends AbstractEntity {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message="Field 'name' is required")
    @Size(min=2)
    private String name;

    @NotBlank(message="Field 'employer' is required")
    @Size(min=2)
    private String employer;


    @NotBlank(message="Field 'location' is required")
    @Size(min=2)
    private String location;

    public Employer(String n, String e, String l){
        this.name= n;
        this.employer=e;
        this.location=l;
    }
    public Employer() {}

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }
}

package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Job extends AbstractEntity{

    @Id
    @GeneratedValue
    private int id;

    private String name;

   @ManyToOne
   @NotNull(message="Field 'employer' required")
    private Employer employer;
    private String skills;

    public Job(int id, String name,  Employer employer, String skills) {
        this.id = id;
        this.name = name;
        this.employer = employer;
        this.skills = skills;
    }

    public Job() {
    }


    // Getters and setters.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}

package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Job extends AbstractEntity{

    @ManyToOne
    @NotNull(message="Field 'employer' required")
    private Employer employer;
    private String skills;

    public Job(Employer employer, String skills) {
        this.employer = employer;
        this.skills = skills;
    }

    public Job() {
    }

    // Getters and setters.

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

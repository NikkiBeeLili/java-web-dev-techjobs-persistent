package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Job extends AbstractEntity{

    @ManyToOne
    @NotNull(message="Field 'employer' required")
    private Employer employer;

    @ManyToMany
    @JoinColumn(name="skill_name")
    private List<Skill> skills= new ArrayList<>();

    public Job(Employer employer, Skill skills) {
        this.employer = employer;
        this.skills = (List<Skill>) skills;
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

    public Skill getSkills() {
        return (Skill) skills;
    }

    public void setSkills(Skill skills) {
        this.skills = (List<Skill>) skills;
    }
}

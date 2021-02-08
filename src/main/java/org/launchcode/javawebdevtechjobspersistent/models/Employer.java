package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {
    @OneToMany(mappedBy="job")
    @JoinColumn(name="job", referencedColumnName="employer")
    private final List<Job> jobs= new ArrayList<>();
    @NotBlank(message="Field 'location' is required")
    @Size(min=2)
    private String location;

    public Employer() {}


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Job> getJobs() {
        return jobs;
    }
}

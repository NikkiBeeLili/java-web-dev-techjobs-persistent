package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {

    @ManyToMany(mappedBy="skills")
    @JoinColumn(name="skills")
    private List<Job> jobs= new ArrayList<>();

    @Size(max=500)
    private String description;

    public Skill(String description){
        this.description = description;
    }
    public Skill(){}


}
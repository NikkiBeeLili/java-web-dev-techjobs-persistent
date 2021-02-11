package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.*;
import org.launchcode.javawebdevtechjobspersistent.models.data.EmployerRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.JobRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping(value = "list")
public class ListController {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private SkillRepository skillRepository;

    private List<Skill> skills= new ArrayList<>();
    private List<Job> jobs= new ArrayList<>();

    static HashMap<String, String> columnChoices = new HashMap<>();
    static HashMap<String, Object> tableChoices = new HashMap<>();

    public ListController() {

        columnChoices.put("all", "All");
        columnChoices.put("employer", "Employer");
        columnChoices.put("location", "Location");
        columnChoices.put("positionType", "description");
        columnChoices.put("coreCompetency", "Skill");

        tableChoices.put("all", "view all");
        tableChoices.put("employer", employerRepository.findAll() );
        tableChoices.put("location", Employer.getLocation());
        tableChoices.put("description", Skill.getDescription());
        tableChoices.put("skills", skillRepository.findAll());
    }




    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("columns", columnChoices);
        model.addAttribute("tableChoices", tableChoices);
        model.addAttribute("all", jobRepository.findAll());
        model.addAttribute("employers", employerRepository.findAll());
        model.addAttribute("locations", Employer.getLocation());
        model.addAttribute("description", Skill.getDescription());
        model.addAttribute("skills", skillRepository.findAll());


        return "list";
    }

    @RequestMapping(value = "jobs")
    public String listJobsByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Job> jobs;
        if (column.toLowerCase().equals("all")) {
            jobs = jobRepository.findAll();
            model.addAttribute("title", "All Jobs");
        } else {
            jobs = JobData.findByColumnAndValue(column, value, jobRepository.findAll());
            model.addAttribute("title", "Jobs with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("jobs", jobs);

        return "list-jobs";
    }

}

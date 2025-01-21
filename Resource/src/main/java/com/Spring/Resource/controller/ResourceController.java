package com.Spring.Resource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Resource.model.ResourceEntity;
import com.Spring.Resource.service.ResourceServiceImpl;

@RestController
@RequestMapping("api/resources")
public class ResourceController {

    @Autowired
    private ResourceServiceImpl resourceService;

    @GetMapping("/microservice")
    public List<String> getResourcesForMicroserviceProject(@RequestParam String skills) {
        // Returns a list of resource names matching the skills for a microservice project
        return resourceService.getResourcesForMicroserviceProject(skills);
    }

    @GetMapping("/cloud")
    public List<String> getResourcesForCloudProject(@RequestParam String skills, @RequestParam int maxExperience) {
        // Returns a list of resource names matching the skills and experience for a cloud project
        return resourceService.getResourcesForCloudProject(skills, maxExperience);
    }
}

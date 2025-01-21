package com.Spring.Resource.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Spring.Resource.model.ResourceEntity;
import com.Spring.Resource.repository.ResourceRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResourceServiceImpl implements ResourceService {

    private static final Logger logger = LoggerFactory.getLogger(ResourceServiceImpl.class);

    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public List<String> getResourcesForMicroserviceProject(String skills) {
        logger.info("Fetching resources for microservice project with skills: {}", skills);
        List<String> requiredSkills = parseSkills(skills);
        List<ResourceEntity> resources = fetchAllResources();

        return resources.stream()
                        .filter(resource -> hasMatchingSkills(resource, requiredSkills, 2))
                        .map(ResourceEntity::getResourceName)
                        .sorted()
                        .peek(resourceName -> logger.debug("Matching Resource: {}", resourceName))
                        .collect(Collectors.toList());
    }

    @Override
    public List<String> getResourcesForCloudProject(String skills, int maxExperience) {
        logger.info("Fetching resources for cloud project with skills: {} and max experience: {}", skills, maxExperience);
        List<String> requiredSkills = parseSkills(skills);
        List<ResourceEntity> resources = fetchAllResources();

        return resources.stream()
                        .filter(resource -> hasMatchingSkills(resource, requiredSkills, 2) &&
                                            resource.getExperience() < maxExperience)
                        .map(ResourceEntity::getResourceName)
                        .sorted()
                        .peek(resourceName -> logger.debug("Matching Resource: {}", resourceName))
                        .collect(Collectors.toList());
    }

    private List<String> parseSkills(String skills) {
        if (skills == null || skills.isEmpty()) {
            logger.warn("Skills input is null or empty.");
            return List.of();
        }
        return Arrays.stream(skills.toLowerCase().split(","))
                     .map(String::trim)
                     .collect(Collectors.toList());
    }

    private List<ResourceEntity> fetchAllResources() {
        try {
            return resourceRepository.findAll();
        } catch (Exception e) {
            logger.error("Error fetching resources from repository", e);
            return List.of();
        }
    }

    private boolean hasMatchingSkills(ResourceEntity resource, List<String> requiredSkills, int minMatchingSkills) {
        List<String> resourceSkills = Arrays.stream(resource.getSkill().toLowerCase().split(","))
                                            .map(String::trim)
                                            .collect(Collectors.toList());
        long matchingSkillsCount = requiredSkills.stream()
                                                 .filter(resourceSkills::contains)
                                                 .count();
        logger.debug("Resource: {}, Matching Skills Count: {}", resource.getResourceName(), matchingSkillsCount);
        return matchingSkillsCount >= minMatchingSkills;
    }
}

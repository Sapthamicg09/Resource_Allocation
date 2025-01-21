package com.Spring.Resource.service;

import java.util.List;

public interface ResourceService
{
    List<String> getResourcesForMicroserviceProject(String skills);
    List<String> getResourcesForCloudProject(String skills, int maxExperience);
}

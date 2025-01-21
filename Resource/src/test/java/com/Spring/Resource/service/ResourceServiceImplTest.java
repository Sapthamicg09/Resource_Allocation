package com.Spring.Resource.service;

import com.Spring.Resource.model.ResourceEntity;
import com.Spring.Resource.repository.ResourceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResourceServiceImplTest {

    @Mock
    private ResourceRepository resourceRepository;

    @InjectMocks
    private ResourceServiceImpl resourceService;

    private ResourceEntity resource1;
    private ResourceEntity resource2;
    private ResourceEntity resource3;
    private ResourceEntity resource4;
    private ResourceEntity resource5;
    private ResourceEntity resource6;

    @BeforeEach
    public void setUp() {
        // Initialize the mock objects
        MockitoAnnotations.openMocks(this);

        // Initialize test data
        resource1 = new ResourceEntity(1, "Dennis", 4, "Java, Spring, JMS, mysql,, Angular, React, Web services, Nodejs");
        resource2 = new ResourceEntity(2, "Thompson", 7, "Java, oracle, React, Angular, Javascript, REST API");
        resource3 = new ResourceEntity(3, "Kim", 12 , "Java, JSP, Spring, Oracle, Mysql, PostgreSQL mongo, Rest API, web services,docker");
        resource4 = new ResourceEntity(4, "Aisha",9 , "Angular, Javascript, Nodejs, Rest API, Web services, Docker, Mysql , PostgreSQL");
        resource5 = new ResourceEntity(5, "Maya", 5 , "Spring, Spring boot, Hibernate , PostgreSQL, Nodejs,python");
        resource6 = new ResourceEntity(6, "Kumar",3 , "Java,Redis, MySQL,Javascript");

        // Mock the repository to return these resources
        when(resourceRepository.findAll()).thenReturn(Arrays.asList(resource1, resource2, resource3 , resource4 , resource5 ,resource6 ));
    }

    @Test
    public void testGetResourcesForMicroserviceProject() {
        String skills = "Java, Redis, Javascript";

        // Expected list of resources who have these skills
        List<String> expected = Arrays.asList("Kumar", "Thompson");

        // Call the service method
        List<String> actual = resourceService.getResourcesForMicroserviceProject(skills);

        // Verify the results
        assertEquals(expected,actual);
    }

    @Test
    public void testGetResourcesForCloudProject() {
        String skills = "Mysql, Docker, Spring, React";
        int maxExperience = 10;

        // Expected list of resources who have these skills and experience
        List<String> expected = Arrays.asList("Aisha" , "Dennis");

        // Call the service method
        List<String> actual = resourceService.getResourcesForCloudProject(skills, maxExperience);

        // Verify the results
        assertEquals(expected, actual);
    }
}

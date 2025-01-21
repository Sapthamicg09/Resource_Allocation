package com.Spring.Resource.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "resource")
public class ResourceEntity 
{
	
	@Id
	private int resourceId;
	private String resourceName;
	private int experience;
	private String skill;
	
	
	// Parameterized constructor
    public ResourceEntity(int resourceId, String resourceName, int experience, String skill) {
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.experience = experience;
        this.skill = skill;
    }
    
    public ResourceEntity() {
		
	}

	
	
	//getter and setter
	
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	

    
	

}

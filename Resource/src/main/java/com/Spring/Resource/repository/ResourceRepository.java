package com.Spring.Resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spring.Resource.model.ResourceEntity;

public interface ResourceRepository extends JpaRepository<ResourceEntity, Integer>
{

}

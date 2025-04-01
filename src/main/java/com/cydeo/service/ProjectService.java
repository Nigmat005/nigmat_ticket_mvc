package com.cydeo.service;

import com.cydeo.dto.ProjectDTO;

import java.util.List;
import java.util.Map;

public interface ProjectService extends CurdService<String, ProjectDTO>{
    @Override
    ProjectDTO save(ProjectDTO object);

    @Override
    ProjectDTO findById(String projectCode);

    @Override
    List<ProjectDTO> findAll();

    @Override
    void update(String projectCode, ProjectDTO object);

    @Override
    void deleteById(String projectCode);

    @Override
    Map<String, ProjectDTO> createAll(List<ProjectDTO> list);

    void completeProject(String projectCode);
}

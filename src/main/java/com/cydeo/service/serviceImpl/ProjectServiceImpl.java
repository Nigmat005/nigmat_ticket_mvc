package com.cydeo.service.serviceImpl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl extends AbstractMapMockDB<String, ProjectDTO> implements ProjectService {

    @Override
    public ProjectDTO save(ProjectDTO project) {
        if(project.getProjectStatus()==null)
            project.setProjectStatus(Status.OPEN);
        return super.save(project.getProjectCode(),project);
    }

    @Override
    public ProjectDTO findById(String projectCode) {
        return super.findById(projectCode);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(String projectCode, ProjectDTO object) {
       super.update(projectCode,object);
    }

    @Override
    public void deleteById(String projectCode) {
        super.softDeleteById(projectCode);
    }

    @Override
    public Map<String, ProjectDTO> createAll(List<ProjectDTO> list) {
        return this.dbMap=list.stream()
                .collect(Collectors.toMap(ProjectDTO::getProjectCode, eachProject->eachProject));
    }

    @Override
    public void completeProject(String projectCode) {
        ProjectDTO projectDTO = this.findById(projectCode);

        projectDTO.setProjectStatus(Status.COMPLETE);

        // Optional to update the same object you modified above
        this.update(projectCode,projectDTO);
    }
}

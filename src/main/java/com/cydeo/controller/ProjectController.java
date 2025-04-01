package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value ={"/project"})
public class ProjectController {
    private final ProjectService projectService;
    private final UserService userService;

    @Autowired
    public ProjectController( ProjectService projectService,UserService userService){
        this.projectService=projectService;
        this.userService=userService;
    }
    @GetMapping(value = "/create")
    public String projectCreate(@ModelAttribute(value = "project") ProjectDTO project, Model model){
        model.addAttribute("projectList",projectService.findAll());
        model.addAttribute("managerList",userService.findManagers());
        return "/project/create";
    }

    @PostMapping(value = "/create")
    public String projectSave(@ModelAttribute(value = "project") ProjectDTO savedProject){
        projectService.save(savedProject);
        return "redirect:/project/create";
    }

    @GetMapping(value = "/update/{id}")
    public String projectEdit(@PathVariable(value = "id") String projectCode,Model model){
        model.addAttribute("projectTobeUpdate",projectService.findById(projectCode));
        model.addAttribute("managerList",userService.findManagers());
        model.addAttribute("projectList",projectService.findAll());
        return "/project/update";
    }

    @PostMapping(value = "/update")
    public String projectEdit( @ModelAttribute("projectTobeUpdate") ProjectDTO updatedProjectDTO){
         if(updatedProjectDTO.getProjectStatus()==null)
             updatedProjectDTO.setProjectStatus(Status.OPEN);
         projectService.update(updatedProjectDTO.getProjectCode(),updatedProjectDTO);
        return "redirect:/project/create";
    }

    @GetMapping(value = "/delete/{projectCode}")
    public String projectDelete(@PathVariable(value = "projectCode") String projectCode){
        projectService.deleteById(projectCode);
        return "redirect:/project/create";
    }

    @GetMapping(value = "/complete/{projectCode}")
    public String projectComplete(@PathVariable("projectCode") String projectCode){
        projectService.completeProject(projectCode);
        return "redirect:/project/create";
    }
}

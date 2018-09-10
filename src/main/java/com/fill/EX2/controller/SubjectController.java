package com.fill.EX2.controller;

import com.fill.EX2.service.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.fill.EX2.service.SubjectService.SubjectDto;

@Controller
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    SubjectServiceImpl subjectService;

    @GetMapping("/all")
    public String getAllSubject(Model model) {
        // add check for  null list
        model.addAttribute("subjects", subjectService.getAllSubject());
        return "subjectList";
    }

    @GetMapping("/subject/{subjectId}")
    public String getSubjectById(@PathVariable("subjectId") Integer subject_id, Model model) {
        model.addAttribute("subject", subjectService.getSubjectById(subject_id));
        return "subjectDetail";
    }

    @GetMapping("/newSubject")
    public String createSubjectPage() {
        return "createSubject";
    }

    @PostMapping("/newSubject")
    public String addSubject(@ModelAttribute("subject") SubjectDto subject) {
        subjectService.addSubject(subject);
        return "redirect:/subjects/all";
    }

    @GetMapping("/delete/{subjectId}")
    public String deleteSubject(@PathVariable("subjectId") Integer subject_id) {
        subjectService.deleteSubject(subject_id);
        return "redirect:/subjects/all";
    }

    @GetMapping("/update/{subjectId}")
    public String updateSubject(@PathVariable("subjectId") Integer subject_id, Model model){
        model.addAttribute("subject", subjectService.getSubjectById(subject_id));
        return "editSubject";
    }

    @PostMapping("/update")
    public String updateSubject(@ModelAttribute("subject") SubjectDto subject){
        subjectService.updateSubject(subject);
        return "redirect:/subjects/subject/"+ subject.getSubjectId();
    }

}

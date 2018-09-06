package com.fill.EX2.controller;

import com.fill.EX2.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.fill.EX2.repository.SubjectRepository.Subject;

@Controller
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @GetMapping("/all")
    public String getAllSubject(Model model) {
        // add check for  null list
        List<Subject> subjectList = subjectService.getAllSubject();
        model.addAttribute("subjects", subjectList);
        return "subjectList";
    }

    @GetMapping("/subject/{subject_id}")
    public String getSubjectById(@PathVariable("subject_id") Integer subject_id, Model model) {
        model.addAttribute("subject", subjectService.getSubjectById(subject_id));
        return "subjectDetail";
    }

    @GetMapping("/newSubject")
    public String createSubjectPage() {
        return "createSubject";
    }

    @PostMapping("/newSubject")
    public String addSubject(@ModelAttribute("subject") Subject subject) {
        subjectService.addSubject(subject);
        return "redirect:/subjects/all";
    }

    @GetMapping("/delete/{subject_id}")
    public String deleteSubject(@PathVariable("subject_id") Integer subject_id) {
        subjectService.deleteSubject(subject_id);
        return "redirect:/subjects/all";
    }

    @GetMapping("/update/{subject_id}")
    public String updateSubject(@PathVariable("subject_id") Integer subject_id, Model model){
        model.addAttribute("subject", subjectService.getSubjectById(subject_id));
        return "editSubject";
    }

    @PostMapping("/update")
    public String updateSubject(@ModelAttribute("subject") Subject subject){
        subjectService.updateSubject(subject);
        return "redirect:/subjects/subject/"+ subject.getId();
    }

}

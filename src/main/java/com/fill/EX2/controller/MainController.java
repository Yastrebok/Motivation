package com.fill.EX2.controller;

import com.fill.EX2.entity.MarksDto;
import com.fill.EX2.service.MarksDaoService;
import com.fill.EX2.service.SubjectService;
import com.fill.EX2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    SubjectService subjectService;

    @Autowired
    MarksDaoService marksDaoService;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    @GetMapping("/allMarks/{user_id}")
    public String getMarksByUser(@PathVariable("user_id") Integer user_id, Model model){
        List<MarksDto> marksDtoList = marksDaoService.getMarkSByUser(user_id);
        model.addAttribute("marksDao", marksDtoList);
        model.addAttribute("user_id", user_id);
        return "marksManager";
    }

    @GetMapping("/allMarks/addMark/{user_id}")
    public String createSubjectPage(@PathVariable("user_id")Integer user_id, Model model) {
        model.addAttribute("listSubject", subjectService.getAllSubject());
        return "marksAdding";
    }

    @PostMapping("/allMarks/addMark")
    public String addSubject(@ModelAttribute("marksDao") MarksDto marksDto) {
        if (marksDto.getDate() == null) {
            marksDto.setDate((java.sql.Date) new java.util.Date());
        }
        marksDaoService.insertMarks(marksDto);
        return "menu";
//        return "redirect:/allMarks/" + marksDto.getUser_id();
    }

}

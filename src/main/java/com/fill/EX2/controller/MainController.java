package com.fill.EX2.controller;

import com.fill.EX2.service.MarkDaoService;
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

import static com.fill.EX2.service.MarkDaoService.MarkDto;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    SubjectService subjectService;

    @Autowired
    MarkDaoService marksDaoService;

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

    @GetMapping("/allMarks/{userId}")
    public String getMarksByUser(@PathVariable("userId") Integer user_id, Model model){
        model.addAttribute("marksDao", marksDaoService.getMarkSByUser(user_id));
        model.addAttribute("userId", user_id);
        return "marksManager";
    }

    @GetMapping("/allMarks/addMark/{userId}")
    public String createSubjectPage(@PathVariable("userId")Integer userId, Model model) {
        model.addAttribute("userName",userService.getUserDtoById(userId).getUsername());
        model.addAttribute("listSubject", subjectService.getAllSubject());
        model.addAttribute("listMarks", marksDaoService.getTemplateMarks());
        return "marksAdding";
    }

    @PostMapping("/allMarks/addMark")
    public String addSubject(@ModelAttribute("marksDao") MarkDto marksDto) {
        marksDaoService.insertMarks(marksDto);
        return "redirect:/allMarks/" + marksDto.getUserId();
    }

}

package app.controller;

import app.entity.Option;
import app.entity.Question;
import app.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class HomePageController {

    @Autowired
    QuestionService questionService;

    @RequestMapping(value = {"/", "/home", "/index"})
    public String getHomePage(Model model) {

        ArrayList<Question> questions = (ArrayList<Question>) questionService.getAllQuestions();
        System.out.println("----- QUESTIONS: ------");
        System.out.println(questions);
        model.addAttribute("allQuestions", questions);
        return "index";
    }
}

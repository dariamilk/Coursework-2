package pro.sky.coursework2.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework2.model.Question;
import pro.sky.coursework2.services.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService questionService;
    public JavaQuestionController (@Qualifier("javaQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping("/add")
    public Question addQuestion (@RequestParam ("question") String question, @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion (@RequestParam ("question") String question, @RequestParam("answer") String answer) {
        Question question1 = new Question(question, answer);
        return questionService.remove(question1);
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }
}

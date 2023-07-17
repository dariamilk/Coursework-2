package pro.sky.coursework2.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.coursework2.exceptions.DoNotHaveEnoughQuestionsException;
import pro.sky.coursework2.model.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;


    public ExaminerServiceImpl (@Qualifier("javaQuestionService") QuestionService javaQuestionService, @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }
    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > javaQuestionService.getAll().size() + mathQuestionService.getAll().size()) {
            throw new DoNotHaveEnoughQuestionsException();
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(getRandomQuestionService().getRandomQuestion());
        }
        return Collections.unmodifiableSet(questions);
    }
    private QuestionService getRandomQuestionService() {
        Random random = new Random();
        switch (random.nextInt(2)) {
            case 0: return javaQuestionService;
            case 1: return mathQuestionService;
            default: return null;
        }
    }
}

package pro.sky.coursework2.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.coursework2.model.Question;
import pro.sky.coursework2.repository.QuestionRepository;

import java.util.Collection;
import java.util.Random;


@Service
public class JavaQuestionService implements QuestionService {

    private final QuestionRepository questionRepository;

    public JavaQuestionService(@Qualifier("javaQuestionRepository")QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        return questionRepository.add(question1);
    }

    @Override
    public Question add(Question question) {
        return questionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int randomIndex = random.nextInt(questionRepository.getAll().size());
        int count = 0;
        for (Question question : questionRepository.getAll()) {
            if (count == randomIndex) {
                return question;
            }
            count++;
        }
        return null;
    }
}

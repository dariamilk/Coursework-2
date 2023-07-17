package pro.sky.coursework2.repository;

import org.springframework.stereotype.Repository;
import pro.sky.coursework2.exceptions.NoSuchQuestionException;
import pro.sky.coursework2.model.Question;

import java.util.Collections;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository {
    private final Set<Question> questions;

    public MathQuestionRepository(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        } else {
            throw new NoSuchQuestionException();
        }
    }

    @Override
    public Set<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }
}

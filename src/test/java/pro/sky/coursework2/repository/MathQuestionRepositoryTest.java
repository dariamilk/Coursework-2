package pro.sky.coursework2.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.coursework2.exceptions.NoSuchQuestionException;
import pro.sky.coursework2.model.Question;
import java.util.HashSet;
import java.util.Set;


class MathQuestionRepositoryTest {
    Set<Question> questions = new HashSet<>();
    QuestionRepository mathQuestionRepository = new MathQuestionRepository(questions);

    @BeforeEach
    void setUp () {
        questions = new HashSet<>();
    }

    @Test
    void add() {
        Question question1 = new Question("3+5", "8");
        Assertions.assertEquals(question1, mathQuestionRepository.add(question1));
    }

    @Test
    void remove() {
        Question question1 = new Question("3+5", "8");
        Question question2 = new Question("2+5", "7");
        mathQuestionRepository.add(question1);
        Assertions.assertEquals(question1, mathQuestionRepository.remove(question1));
        Assertions.assertThrows(NoSuchQuestionException.class, () -> mathQuestionRepository.remove(question2));
    }

    @Test
    void getAll() {
        Question question1 = new Question("3+5", "8");
        Assertions.assertTrue(mathQuestionRepository.getAll().isEmpty());
        mathQuestionRepository.add(question1);
        Assertions.assertEquals(1, mathQuestionRepository.getAll().size());
    }
}
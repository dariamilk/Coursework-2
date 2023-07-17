package pro.sky.coursework2.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.coursework2.exceptions.NoSuchQuestionException;
import pro.sky.coursework2.model.Question;
import java.util.HashSet;
import java.util.Set;


class JavaQuestionRepositoryTest {
    Set<Question> questions = new HashSet<>();
    JavaQuestionRepository javaQuestionRepository = new JavaQuestionRepository(questions);

    @BeforeEach
    void setUp () {
        questions = new HashSet<>();
    }
    @Test
    void add() {
        Question question1 = new Question("question1", "answer1");
        Assertions.assertEquals(question1, javaQuestionRepository.add(question1));
    }

    @Test
    void remove() {
        Question question1 = new Question("question1", "answer1");
        Question question2 = new Question("question2", "answer2");
        javaQuestionRepository.add(question1);
        Assertions.assertEquals(question1, javaQuestionRepository.remove(question1));
        Assertions.assertThrows(NoSuchQuestionException.class, () -> javaQuestionRepository.remove(question2));

    }

    @Test
    void getAll() {
        Question question1 = new Question("question1", "answer1");
        Assertions.assertTrue(javaQuestionRepository.getAll().isEmpty());
        javaQuestionRepository.add(question1);
        Assertions.assertEquals(1, javaQuestionRepository.getAll().size());
    }
}
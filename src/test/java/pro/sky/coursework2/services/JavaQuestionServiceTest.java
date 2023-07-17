package pro.sky.coursework2.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.model.Question;
import pro.sky.coursework2.repository.JavaQuestionRepository;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    private final static String QUESTION = "question1";
    private final static String ANSWER = "answer1";

    @Mock
    JavaQuestionRepository javaQuestionRepository;
    @InjectMocks
    JavaQuestionService javaQuestionService;

    @Test
    void add() {
        Question question1 = new Question(QUESTION, ANSWER);
        Mockito.when(javaQuestionRepository.add(question1)).thenReturn(question1);
        Assertions.assertEquals(question1, javaQuestionService.add(QUESTION, ANSWER));
    }

    @Test
    void testAdd() {
        Question question1 = new Question(QUESTION, ANSWER);
        Mockito.when(javaQuestionRepository.add(question1)).thenReturn(question1);
        Assertions.assertEquals(question1, javaQuestionService.add(question1));
    }

    @Test
    void remove() {
        Question question1 = new Question(QUESTION, ANSWER);
        Mockito.when(javaQuestionRepository.remove(question1)).thenReturn(question1);
        Assertions.assertEquals(question1, javaQuestionService.remove(question1));
    }

    @Test
    void getAll() {
        Question question1 = new Question(QUESTION, ANSWER);
        Set<Question> questions = new HashSet<>();
        questions.add(question1);
        Mockito.when(javaQuestionRepository.getAll()).thenReturn(Collections.unmodifiableSet(questions));
        Assertions.assertEquals(questions, javaQuestionService.getAll());
    }

    @Test
    void getRandomQuestion() {
        Question question1 = new Question(QUESTION, ANSWER);
        Question question2 = new Question(QUESTION, ANSWER);
        Question question3 = new Question(QUESTION, ANSWER);
        Set<Question> questions = new HashSet<>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        Mockito.when(javaQuestionRepository.getAll()).thenReturn(Collections.unmodifiableSet(questions));
        Assertions.assertEquals(ANSWER, javaQuestionService.getRandomQuestion().getAnswer());
    }
}
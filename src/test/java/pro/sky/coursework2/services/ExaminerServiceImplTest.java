package pro.sky.coursework2.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.exceptions.DoNotHaveEnoughQuestionsException;
import pro.sky.coursework2.model.Question;

import java.util.Collections;
import java.util.HashSet;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    private final static String QUESTION_JAVA = "question1";
    private final static String ANSWER_JAVA = "answer1";
    private final static String QUESTION_MATH = "2+5";
    private final static String ANSWER_MATH = "7";
    @Mock
    JavaQuestionService javaQuestionService;
    @Mock
    MathQuestionService mathQuestionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;
    @Test
    void getQuestions() {
        Question questionJava = new Question(QUESTION_JAVA, ANSWER_JAVA);
        Question questionJava2 = new Question(QUESTION_JAVA, ANSWER_JAVA);
        Question questionJava3 = new Question(QUESTION_JAVA, ANSWER_JAVA);
        HashSet<Question> javaSet = new HashSet<>();
        javaSet.add(questionJava);
        javaSet.add(questionJava2);
        javaSet.add(questionJava3);
        Question questionMath = new Question(QUESTION_MATH, ANSWER_MATH);
        Question questionMath2 = new Question(QUESTION_MATH, ANSWER_MATH);
        Question questionMath3 = new Question(QUESTION_MATH, ANSWER_MATH);
        HashSet<Question> mathSet = new HashSet<>();
        mathSet.add(questionMath);
        mathSet.add(questionMath2);
        mathSet.add(questionMath3);
        Mockito.when(javaQuestionService.getAll()).thenReturn(Collections.unmodifiableSet(javaSet));
        Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(questionJava);
        Mockito.when(mathQuestionService.getAll()).thenReturn(Collections.unmodifiableSet(mathSet));
        Mockito.when(mathQuestionService.getRandomQuestion()).thenReturn(questionMath);
        Assertions.assertThrows(DoNotHaveEnoughQuestionsException.class, () -> examinerService.getQuestions(20));
        Assertions.assertDoesNotThrow(() -> examinerService.getQuestions(2));
    }
}
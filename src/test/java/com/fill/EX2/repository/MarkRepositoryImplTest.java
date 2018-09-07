package com.fill.EX2.repository;

import com.fill.EX2.Application;
import com.fill.EX2.WebAppInitializer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

import static com.fill.EX2.repository.MarkRepository.Mark;
import static com.fill.EX2.repository.SubjectRepository.Subject;
import static com.fill.EX2.repository.UserRepository.User;
import static org.junit.Assert.assertEquals;

@SpringBootConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {Application.class, WebAppInitializer.class})
public class MarkRepositoryImplTest {

    @Autowired
    private MarkRepository markRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @Test
    public void TestMarks() {
        // create test user and subject
        User testUser = User.builder().build();
        Subject testSubject = Subject.builder().build();

        // save test user and subject for unique id
        Integer testUserId = userRepository.saveUser(testUser);
        Integer testSubjectId = subjectRepository.addSubject(testSubject);

        Mark newMark = Mark.builder()
                .user_id(testUserId)
                .subject_id(testSubjectId)
                .mark(10)
                .rate(1)
                .date(LocalDateTime.of(2012, 6, 30, 12, 00))
                .build();

        Integer id = markRepository.insertMarks(newMark);
        newMark.setId(id);
        assertEquals(newMark, markRepository.getMarksByUser(testUserId).get(0));
    }
}
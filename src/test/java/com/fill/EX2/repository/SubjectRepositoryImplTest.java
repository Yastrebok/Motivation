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

import static com.fill.EX2.repository.SubjectRepository.Subject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@SpringBootConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes ={ Application.class, WebAppInitializer.class})
public class SubjectRepositoryImplTest {
    private static final int RATE = 2;

    @Autowired
    private SubjectRepository subjectRepository;

    @Test
    public void getAllSubject() {
    }

    @Test
    public void subjectCRUD() {
        //Create new test subject
        Subject subject = Subject.builder()
                .subjectName("testSubject")
                .rate(1)
                .build();

        //save new subject
        Integer idSavedSubject = subjectRepository.addSubject(subject);

        // get subject by id
        Subject savedSubject = subjectRepository.getSubjectById(idSavedSubject);
        assertNotNull("Just added subject should be in result", savedSubject);

        // update subject
        savedSubject.setRate(RATE);
        subjectRepository.updateSubject(savedSubject);
        Subject updatedSubject = subjectRepository.getSubjectById(savedSubject.getId());
        assertNotNull("Just updated subject should be in result",updatedSubject);
        assertEquals("Updated parameter should be the same", RATE, updatedSubject.getRate());

        //delete subject
        subjectRepository.deleteSubject(idSavedSubject);
        assertNull("Just null should be", subjectRepository.getSubjectById(idSavedSubject));
    }
}
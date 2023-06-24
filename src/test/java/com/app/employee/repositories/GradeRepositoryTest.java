package com.app.employee.repositories;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import com.app.employee.models.Grade;
import com.github.javafaker.Faker;

@SpringBootTest
public class GradeRepositoryTest {
	@Autowired
    private GradeRepository gradeRepository;
	private Faker faker = new Faker();
	
	@Test
    public void testFindGradeByCode() {
		// Define random code and bonus between x, y range
		int randomCode = faker.random().nextInt(5, 1001);
		int randomPercentageBonus = faker.random().nextInt(0, 16);
		
        // Create a test grade
        Grade grade = new Grade();
        grade.setCode(randomCode);
        grade.setDescription(faker.job().title());
        grade.setPercentageBonus(randomPercentageBonus);
        gradeRepository.save(grade);

        // Find the grade by code
        Optional<Grade> foundGrade = gradeRepository.findByCode(grade.getCode());
        System.out.println(gradeRepository);
        System.out.println(foundGrade);

        // Assert that the grade is found
        assertTrue(foundGrade.isPresent());
        assertNotNull(foundGrade.get().getCode());
        assertNotNull(foundGrade.get().getDescription());
        assertNotNull(foundGrade.get().getPercentageBonus());
    }
}

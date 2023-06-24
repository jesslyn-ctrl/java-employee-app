package com.app.employee.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GradeTest {
	@Test
    public void testNullFields() {
        // Create a Grade instance with empty constructor
        Grade grade = new Grade();

        // Assert that all fields are initially null
        assertNull(grade.getId());
        assertEquals(0, grade.getCode());
        assertNull(grade.getDescription());
        assertEquals(0.0f, grade.getPercentageBonus());

        // Set values to null using the setters
        grade.setId(null);
        grade.setCode(0);
        grade.setDescription(null);
        grade.setPercentageBonus(0.0f);

        assertNull(grade.getId());
        assertEquals(0, grade.getCode());
        assertNull(grade.getDescription());
        assertEquals(0.0f, grade.getPercentageBonus());
    }
	
	@Test
    public void testConstructorAndGettersSetters() {
        // Create a Grade instance
        Grade grade = new Grade(1L, 1, "Staff", 3);

        // Assert all values with getters
        assertEquals(1L, grade.getId());
        assertEquals(1, grade.getCode());
        assertEquals("Staff", grade.getDescription());
        assertEquals(3, grade.getPercentageBonus());

        // Modify the values using setters
        grade.setId(2L);
        grade.setCode(2);
        grade.setDescription("Supervisor");
        grade.setPercentageBonus(6.5f);

        // Assert all values after being modified
        assertEquals(2L, grade.getId());
        assertEquals(2, grade.getCode());
        assertEquals("Supervisor", grade.getDescription());
        assertEquals(6.5f, grade.getPercentageBonus());
    }
}

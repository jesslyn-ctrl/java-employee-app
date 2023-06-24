package com.app.employee.seed;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.employee.models.Grade;
import com.app.employee.repositories.GradeRepository;

@Component
public class DataSeeder implements CommandLineRunner  {
	private final GradeRepository gradeRepository;
	private final boolean dataSeedingEnabled;

    public DataSeeder(GradeRepository gradeRepository, @Value("${app.data-seeding.enabled:false}") boolean dataSeedingEnabled) {
        this.gradeRepository = gradeRepository;
        this.dataSeedingEnabled = dataSeedingEnabled;
    }
    
    @Override
    public void run(String... args) {
        if (dataSeedingEnabled) {
            seedGradeData();
        }
    }

    private void seedGradeData() {
        Grade grade1 = new Grade(1L, 1, "Manager", 10);
        Grade grade2 = new Grade(2L, 2, "Supervisor", 6);
        Grade grade3 = new Grade(3L, 3, "Staff", 3);

        gradeRepository.save(grade1);
        gradeRepository.save(grade2);
        gradeRepository.save(grade3);
    }
}

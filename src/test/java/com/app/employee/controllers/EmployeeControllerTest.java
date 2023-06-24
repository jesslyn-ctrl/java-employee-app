package com.app.employee.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.app.employee.dtos.requests.EmployeeRequest;
import com.app.employee.dtos.requests.GradeRequest;
import com.app.employee.dtos.responses.EmployeeResponse;
import com.app.employee.dtos.responses.GradeResponse;
import com.app.employee.models.Employee;
import com.app.employee.services.EmployeeService;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
    private EmployeeService employeeService;

    private List<EmployeeResponse> employeeList;
    
    @BeforeEach
    public void setup() {
        // Initialize a list of EmployeeResponse for testing
    	GradeResponse gradeResponse1 = new GradeResponse(2, "Supervisor");
    	GradeResponse gradeResponse2 = new GradeResponse(3, "Staff");
    	
        employeeList = new ArrayList<>();
        employeeList.add(new EmployeeResponse(1L, "Jane", 7000000L, gradeResponse1, 5300000L));
        employeeList.add(new EmployeeResponse(2L, "Marie", 5000000L, gradeResponse2, 5150000L));
    }
    
    @Test
    public void testCreateEmployee() throws Exception {
    	// Create a grade request
    	GradeRequest gradeRequest = new GradeRequest(2);
    	
        // Create a request body
        EmployeeRequest request = new EmployeeRequest();
        request.setName("Jane");
        request.setSalary(7000000L);
        request.setGrade(gradeRequest);

        // Create a mocked Employee object as the response from the service
        Employee mockedEmployee = new Employee();
        mockedEmployee.setId(1L);
        mockedEmployee.setName("Jane");
        mockedEmployee.setSalary(7000000L);

        // Mock the behavior of createEmployee() method
        Mockito.when(employeeService.createEmployee(any(EmployeeRequest.class))).thenReturn(mockedEmployee);

        // Perform the POST request
        mockMvc.perform(MockMvcRequestBuilders.post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Jane\",\"salary\":7000000}"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Jane"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.salary").value(7000000));
        
        assertNotNull(mockedEmployee);
        assertEquals(1L, mockedEmployee.getId());
        assertEquals("Jane", mockedEmployee.getName());
        assertEquals(7000000L, mockedEmployee.getSalary());
    }
    
    @Test
    public void testUpdateEmployee() throws Exception {
    	// Create a grade request
    	GradeRequest gradeRequest = new GradeRequest(2);
    	
        // Create a request body
        EmployeeRequest request = new EmployeeRequest();
        request.setName("J");
        request.setSalary(7500000L);
        request.setGrade(gradeRequest);

        // Create a mocked Employee object as the response from the service
        Employee mockedEmployee = new Employee();
        mockedEmployee.setId(1L);
        mockedEmployee.setName("Jane");
        mockedEmployee.setSalary(7500000L);

        // Mock the behavior of updateEmployee() method
        Mockito.when(employeeService.updateEmployee(Mockito.eq(1L), Mockito.any(EmployeeRequest.class)))
                .thenReturn(mockedEmployee);

        // Perform the PUT request
        mockMvc.perform(MockMvcRequestBuilders.put("/api/employees/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Jane\",\"salary\":7500000}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Jane"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.salary").value(7500000));

        assertNotNull(mockedEmployee);
        assertEquals(1L, mockedEmployee.getId());
        assertEquals("Jane", mockedEmployee.getName());
        assertEquals(7500000L, mockedEmployee.getSalary());
    }
    
    @Test
    public void testGetAllEmployees() throws Exception {
        // Mock the behavior of getAllEmployees() method
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employeeList);

        // Perform the GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/api/employees"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(employeeList.size()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Jane"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].salary").value(7000000))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Marie"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].salary").value(5000000));
    }
    
    @Test
    public void testGetDetailEmployee() throws Exception {
        // Create a mocked Employee object as the response from the service
        Employee mockedEmployee = new Employee();
        mockedEmployee.setId(1L);
        mockedEmployee.setName("Jane");
        mockedEmployee.setSalary(7000000L);

        // Mock the behavior of the getDetailEmployee() method
        Mockito.when(employeeService.getDetailEmployee(Mockito.eq(1L))).thenReturn(mockedEmployee);

        // Perform the GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/api/employees/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Jane"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.salary").value(7000000));

        assertNotNull(mockedEmployee);
        assertEquals(1L, mockedEmployee.getId());
        assertEquals("Jane", mockedEmployee.getName());
        assertEquals(7000000L, mockedEmployee.getSalary());
    }
}

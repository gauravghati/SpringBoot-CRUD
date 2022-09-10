package com.springboot.ecommerce;

import com.springboot.ecommerce.model.Employee;
import com.springboot.ecommerce.repository.EmployeeRepository;
import com.springboot.ecommerce.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ECommerceApplicationTests {
	@Mock
	EmployeeRepository employeeRepository;
	@InjectMocks
	EmployeeServiceImpl employeeService;

	@Test
	public void testGetAllEmployee() {
		List<Employee> fewEmployees = new ArrayList<Employee>();
		fewEmployees.add(new Employee("Gaurav", "Ghati", "gauravghatii@gmail.com"));
		fewEmployees.add(new Employee("Ellika", "Mishra", "ellikamishra@gmail.com"));

		when(employeeRepository.findAll()).thenReturn(fewEmployees);

		List<Employee> employeeList = employeeService.getAllEmployees();
		int sizeEmployeeList = employeeList.size();
		assertEquals(2, sizeEmployeeList);
		assertEquals(fewEmployees, employeeList);
	}
}

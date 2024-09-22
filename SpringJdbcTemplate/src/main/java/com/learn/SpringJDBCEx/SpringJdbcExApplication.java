package com.learn.SpringJDBCEx;

import com.learn.SpringJDBCEx.service.StudentService;
import com.learn.SpringJDBCEx.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcExApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcExApplication.class, args);

		Student s = context.getBean(Student.class);
		s.setRollNum(34);
		s.setName("Aylish");
		s.setMarks(100);

		StudentService service = context.getBean(StudentService.class);
		service.addStudent(s); // student being added to service layer from the client (main)

		/* To fetch the students data from h2 database
		 * First the request being sent to service layer and then repo layer to fetch the data
		*/
		System.out.println("Fetching students data");
		List<Student> students = service.getStudents();
		System.out.println(students);



	}

}

package com.student.stddetails;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.student.stddetails.model.Student;
import com.student.stddetails.repository.StudentRepository;

@SpringBootTest
class StudentDetailsApplicationTests {

	//@Test
	//void contextLoads() {
	//}
	@Autowired
	StudentRepository StRepo;
	
	@Test
	public void testCreate() {
		
		Student s = new Student();
		s.setId(4);
		s.setFirstName("Jerin");
		s.setLastName("Thomas");
		s.setCourse("MCA");
		StRepo.save(s);
		assertNotNull(StRepo.findById((long) 4).get());
		
	}
	
	@Test
	public void testReadAll() {
		
		List<Student> list = StRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
		
	}
	
	@Test
	public void testSingle() {
		
		Student student = StRepo.findById((long)4).get();
		assertEquals("MCA", student.getCourse());
		
	}
	
	@Test
	public void testUpdate() {
		
		Student s = StRepo.findById((long) 4).get();
		s.setCourse("Econometrics");
		StRepo.save(s);
		assertNotEquals("MCA", StRepo.findById((long)4).get().getCourse());
		
	}
	
	@Test
	public void testDelete() {
		
		StRepo.deleteById((long)2);
		assertThat(StRepo.existsById((long) 2)).isFalse();
		
	}

}

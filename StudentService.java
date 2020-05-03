package com.SpringExample.Student;

import java.util.List;

public interface StudentService {
	public int save(Student student);
	public boolean updateStudent(Student student);
	public boolean deleteStudent(Student student);
//	public Student findByID(int mobileNumber);
	public Student findByName(int mobileNumber);
	public List<Student> findAll();

}

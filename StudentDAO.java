package com.SpringExample.Student;

import java.util.List;

public interface StudentDAO {


	public int save(Student student);
	public boolean updateStudent(Student student);
	public boolean deleteStudent(Student student);
	public Student findByName(int mobileNumber);
	public List<Student> findAll();
}


package com.SpringExample.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component("studentDAOImplBean")
@Repository
public class StudentDAOImpl implements StudentDAO {

	Number generatedId=0;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int save(Student student) {
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		generatedId = keyHolder.getKey();
		double totalMarks = (student.getMarks1()+student.getMarks2()+student.getMarks3()); 
		double average = totalMarks/3 ;
		double percentage = (totalMarks/30)*100;
		String sql = "INSERT into student_table value (?,?,?,?,?,?,?,?)";
		int update = jdbcTemplate.update(sql, new Object[]{generatedId ,student.getMobileNumber(), student.getName(), student.getMarks1(), student.getMarks2(), student.getMarks3(), average, percentage});
		System.out.println("Student Created......."+update);
		return update;
	}

	@Override
	public boolean updateStudent(Student student) {
		String sql ="UPDATE student_table set Name=? where Mobile_Number = ? ";
		try
		{	if(jdbcTemplate.update(sql, student.getName(), student.getMobileNumber())!=0)
			{	//jdbcTemplate.update(sql, student.getName(), student.getMobileNumber());
				System.out.println("Student Updated");
			}
		else
			System.out.println("Record not found!!");
		}catch(EmptyResultDataAccessException ex)
		{
			System.out.println("Record not found!!");
		}
		return false;
	}

	@Override
	public boolean deleteStudent(Student student) {
		String sql = "DELETE from student_table where Mobile_Number=?";
		try
		{
			jdbcTemplate.update(sql, student.getMobileNumber());
	        System.out.println("Student deleted");
		} catch(EmptyResultDataAccessException ex)
		{
			System.out.println("Record not found!!");
		}
		return false;
	}


	@Override
	public Student findByName(int mobileNumber) {
		
		Student result = null;
		String sql = "SELECT * from student_table where Mobile_Number=?";
		try
		{
			if(jdbcTemplate.queryForObject(sql,  new StudentRowMapper(), mobileNumber)!= null)
			{	
				result = jdbcTemplate.queryForObject(sql,  new StudentRowMapper(), mobileNumber);
				System.out.println("the student's details are:");
				System.out.println("Roll Number:\t"+ result.getRollNumber());
				System.out.println("Mobile Number:\t"+ result.getMobileNumber());
				System.out.println("Name:\t"+ result.getName());
				System.out.println("Marks1\t"+ result.getMarks1());
				System.out.println("Marks2\t"+ result.getMarks2());
				System.out.println("Marks3\t"+ result.getMarks3());
				System.out.println("Average\t"+ result.getAverage());
				System.out.println("Percentage\t"+ result.getPercentage());		
				
			}
			else if(jdbcTemplate.queryForObject(sql,  new StudentRowMapper(), mobileNumber)==null)
			{
				System.out.println("Record not found!!");
			
			}
			
		}catch(EmptyResultDataAccessException ex)
		{
			System.out.println("Record not found!!");
		}
		return result;
	}

	@Override
	public List<Student> findAll() {
		String sql = "SELECT * from student_table";
		List<Student> list = jdbcTemplate.query(sql, new StudentRowMapper());
		return list;
	}

}

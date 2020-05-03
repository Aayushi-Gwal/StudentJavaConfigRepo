package com.SpringExample.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


@Component("studentRowMapperBean")
public class StudentRowMapper implements RowMapper<Student> {
	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setRollNumber(rs.getInt(1));
		student.setMobileNumber(rs.getInt(2));
		student.setName(rs.getString(3));
		student.setMarks1(rs.getDouble(4));
		student.setMarks2(rs.getDouble(5));
		student.setMarks3(rs.getDouble(6));
		student.setAverage(rs.getDouble(7));
		student.setPercentage(rs.getDouble(8));
		return student;
	}

}

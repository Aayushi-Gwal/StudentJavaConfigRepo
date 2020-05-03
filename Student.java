package com.SpringExample.Student;

public class Student {

	private int rollNumber;
	private int mobileNumber;
	private String name;
	private double marks1;
	private double marks2;
	private double marks3;
	private double average;
	private double percentage;

	
	
	public Student()
	{
		
	}


	public Student(int rollNumber,int mobileNumber, String name, double marks1, double marks2, double marks3,
			double average, double percentage) {
		this.rollNumber = rollNumber;
		this.mobileNumber = mobileNumber;
		this.name = name;
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.marks3 = marks3;
		this.average = average;
		this.percentage = percentage;
		
	}
	


	public int getRollNumber() {
		return rollNumber;
	}


	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}


	public int getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getMarks1() {
		return marks1;
	}


	public void setMarks1(double marks1) {
		this.marks1 = marks1;
	}


	public double getMarks2() {
		return marks2;
	}


	public void setMarks2(double marks2) {
		this.marks2 = marks2;
	}


	public double getMarks3() {
		return marks3;
	}


	public void setMarks3(double marks3) {
		this.marks3 = marks3;
	}


	public double getAverage() {
		return average;
	}


	public void setAverage(double average) {
		this.average = average;
	}


	public double getPercentage() {
		return percentage;
	}


	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}


	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", mobileNumber=" + mobileNumber + ", name=" + name + ", marks1="
				+ marks1 + ", marks2=" + marks2 + ", marks3=" + marks3 + ", average=" + average + ", percentage="
				+ percentage + "]";
	}

	
	
}

package com.capgemini.beans;
	public class Student {
		private int rollNumber;
		private String name;
		private String[] courses;
		public Student(int rollNumber,String name,String[] courses) {
			this.rollNumber=rollNumber;
			this.name=name;
			this.courses=courses;
		}
		public int getRollNumber() {
			return rollNumber;
		}
		public void setRollNumber(int rollNumber) {
			this.rollNumber = rollNumber;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String[] getCourses() {
			return courses;
		}
		public void setCourses(String[] courses) {
			this.courses = courses;
		}
		

	}


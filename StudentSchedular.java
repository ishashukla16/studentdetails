package com.capgemini.service;
import com.capgemini.beans.Student;
import java.util.Scanner;
public class StudentSchedular {
private Student[] students=new Student[10];
private int counterStudent;
Scanner sc=new Scanner(System.in);
public String addStudent(int rollNumber,String name,String[] courses)
{
	students[counterStudent++]=new Student(rollNumber, name, courses);
	return "student added successfully";
	
}
public void showAllStudents()
{
	if(counterStudent==0)
		System.out.println("no details");
	else
	{
		System.out.println("showing data");
		
	for(int j=0;j<counterStudent;j++)
	{
	//students[j]=new Student();
	String[] courses=students[j].getCourses();
		System.out.println(students[j].getRollNumber());
		System.out.println(students[j].getName());
		System.out.println("no. of subjects are:");
		for(int i=0;i<courses.length;i++)
		{
			System.out.println(courses[i]);
		}
		
	}
	}
}
void validateRollNo() 
{
	System.out.println("Enter Roll Number:");
	int rollNum=sc.nextInt();
	for(Student s:students)
	{
	{
		if(rollNum==s.getRollNumber())
			break;
	//}
	//{
		//System.out.println("A Record exist with this roll number,"
		//		+ " Please enter some different number!");
		//return validateRollNo();
	//}
	else
		System.out.println("this is new roll no");
		//return rollNum;	
	}
	}
}
public void showByCoursename(String courseName)

{
	if(students==null)
		System.out.println("No Records Entered");
	else
	{
		
		//int count=0;
		for(int i=0;i<counterStudent;i++)
		{
			for(String course:students[i].getCourses()) 
			{
				if(courseName.equalsIgnoreCase(course))
				{
					System.out.println("Roll Number: "+students[i].getRollNumber());
					System.out.println("Name: "+students[i].getName());
					System.out.print("Courses Registered: ");
					for(String course1:students[i].getCourses()) 
					{
						System.out.print(course1+" ");
					}
					System.out.println("\n");
				}
			}
		}
	}	
}
public void showByRollnumber()
{
	{
		if(students==null)
			System.out.println("No Records Entered");
		else
		{
			System.out.println("Enter Roll Number to search Record:");
			int rollNum=sc.nextInt();
			for(Student s:students)
			{
				if(rollNum==s.getRollNumber())
				{
					System.out.println("Roll Number: "+s.getRollNumber() );
					System.out.println("Name: "+s.getName());
					System.out.print("Courses Registered: ");
					for(String course:s.getCourses()) 
					{
						System.out.print(course+" ");
					}
	
	break;
		}
				else
					System.out.println("no results..try again with another roll no");
				break;
	}
			
}
}
}
public void showCountByCoursename(String Course)

{
	
	int countStudent=0;
	for(int i=0;i<counterStudent;i++)
	{
		String[] Courses=students[i].getCourses();
		for(int j=0;j<Courses.length;j++)
		{
			if(Courses[j].equals(Course))
			{
				countStudent++;
				break;
			}
		}
}
	System.out.println("no of student for this course"+countStudent);
}
}









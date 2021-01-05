package com.capgemini.view;
import com.capgemini.service.*;
import java.util.Scanner;

public class Admin {

	private static Scanner sc=new Scanner(System.in);
	private static StudentSchedular studSch = new StudentSchedular();
	public static void main(String[] args) {
		showMenu();
	}

	private static void showMenu() {
		
		int choice;
		
		while(true)
		{
			System.out.println("1.add student");
			System.out.println("2.show all students");
			System.out.println("3.show students detail by roll number");
			System.out.println("4.show student detail by course name");
			System.out.println("5.show count by course name");
			System.out.println("6.exit");
			
			System.out.println("Enter your choice");
			choice=sc.nextInt();
			
			
			switch(choice)
			{
			case 1:addStudentDetails();
			       break;  
			 case 2:showAllStudents();
			        break;
			 case 3:showByRollnumber();
			       break;
			        case 4:showByCoursename();
			        break;
			        case 5:showCountByCoursename();
			        break;
			        case 6:System.exit(0);
			 default:System.out.println("Sorry entered wrong choice");   
			}
			
		}
		
	}

	private static void showAllStudents() {
		studSch.showAllStudents();
		
	}
	private static void showByCoursename()
	{
		System.out.println("Enter Course:");
		String courseSearch=sc.next();
		studSch.showByCoursename(courseSearch);
		
	}
	private static void showByRollnumber()
	{
		studSch.showByRollnumber();
	}
	public static void showCountByCoursename()
	{
		System.out.println("enter course name:");
		String Courses=sc.next();
		studSch.showCountByCoursename(Courses);
	}

	private static void addStudentDetails() {
		System.out.println("Enter roll number");
		int rollNumber=sc.nextInt();
		
		System.out.println("Enter name");
		String name = sc.next();
		
		System.out.println("enter no. of courses");
		 int no=sc.nextInt();
		 String[] courses=new String[no];
		 System.out.println("enter name of courses");
         for(int j=0;j<no;j++)
         {
             courses[j]=sc.next();
         }
		
		System.out.println(studSch.addStudent(rollNumber, name ,courses));
		
	}

}
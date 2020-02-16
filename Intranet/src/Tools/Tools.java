package Tools;

import java.util.Vector;

import Courses.Course;
import User.Teacher;

public interface Tools {
	public static void viewCourses(Object obj) {
		Vector<Course> courses = (Vector<Course>)obj;
		for(int i = 1; i <= courses.size(); i++) {
			System.out.println(i + " " + courses.elementAt(i-1).getName())
		}
	}
	public static void viewTeachers(Object obj) {
		Vector<Course> courses = (Vector<Course>)obj;
		for(Course course:courses) {
			System.out.println(course.getName() + ":");
			Vector<Teacher> teachers = course.getTeachers();
			for(Teacher teacher:teachers) {
				System.out.println(teacher.getName() + " " + teacher.getLastname());
			}
		}
	};
	public static Object downloadFiles(Object obj1, Object obj2) {
		Vector<Course> courses = (Vector<Course>)obj1;
		Vector<Object> files = (Vector<Object>)obj2;
		for(Course course:courses) {
			Vector<Object>	courseFiles = course.getFiles();
			for(Object object:courseFiles) {
				if(files.contains(object) == false)
				files.add(object);
			}
		}
		return files;
	}
	
}

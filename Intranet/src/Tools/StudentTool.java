package Tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Vector;

import Courses.Course;
import Courses.Mark;
import User.Teacher;

public class StudentTool implements Tools {
	
	public static int viewMark(Object obj, Map<Course, Mark> mark) {
		System.out.println("Choose a needed course by entering its number: ");
		Tools.viewCourses(obj);
		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
		int n = reader.hashCode();
		Vector<Course> courses = (Vector<Course>)obj;
		Course neededCourse = courses.elementAt(n-1);
		return mark.get(neededCourse).getMark();
	}
	public static void viewTranscript(Object obj, Map<Course, Mark> mark) {
		Vector<Course> courses = (Vector<Course>)obj;
		for(Course course:courses) {
			System.out.println(mark.get(course).getMark());
		}
	}
	
}

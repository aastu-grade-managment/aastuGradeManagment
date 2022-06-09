package server.implmentRemoteInterface;

import java.rmi.server.UnicastRemoteObject;
import java.sql.*;

import shared.classes.*;
import shared.remoteInterface.*;
import java.util.*;

import server.database.DbConnection;

public class implementCourse  implements courseInterface {
	Connection con;
	ArrayList<Course>courses = new ArrayList<Course>();

	public implementCourse(){
		try {	
			UnicastRemoteObject.exportObject(this, 0);
			DbConnection connection = new DbConnection();
            con = connection.getConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public int addCourse(Course course) {
		int row = 0;
		System.out.println(course.getCourseId());
		System.out.println(course.getCourseName());
		System.out.println(course.getCreaditHour());
		System.out.println(course.getSectiond());
		try{
			String query = "insert into course(course_id, course_name,credit_hour, section_id) values(?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(query);  
			stmt.setString(1, course.getCourseId());
            stmt.setString(2, course.getCourseName());
            stmt.setInt(3,course.getCreaditHour());
            stmt.setString(4, course.getSectiond());
			row = stmt.executeUpdate();   
			System.out.println(query);
		}catch(Exception er){
			System.out.println(er);
		}
		return row;
	}

	@Override
	public ArrayList<Course> getCourse(String query) {
		try{
			PreparedStatement stmt=con.prepareStatement(query);  
			ResultSet rt = stmt.executeQuery();
			if(courses.size()>0){
				courses.clear();
			}
			while(rt.next()){
				String courseId = rt.getString("course_id");
                String courseName = rt.getString("course_name");
                int creditHour = rt.getInt("credit_hour");
                String sectionId = rt.getString("section_id");
				Course cour = new Course(courseId, courseName, creditHour);
                cour.setSectionId(sectionId);
				courses.add(cour);
			}
		}catch(Exception er){
			System.out.println(er);
		}
		return courses;
	}
	
}

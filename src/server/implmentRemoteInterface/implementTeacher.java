package server.implmentRemoteInterface;

import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import shared.classes.*;
import shared.remoteInterface.*;
import java.util.*;
import server.database.DbConnection;

public class implementTeacher  implements teacherInterface {
	Connection con;
	ArrayList<Teacher>teachers = new ArrayList<Teacher>();

	public implementTeacher(){
		try {		
			UnicastRemoteObject.exportObject(this, 0);
			DbConnection connection = new DbConnection();
            con = connection.getConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@Override
	public int addTeacher(Teacher teacher) {
		int row = 0;
		// System.out.println(section.getAllTeacher().get(0).getFirstName());
		// System.out.println(section.getAllTeacher().get(0).getLastName());
		// System.out.println(section.getAllTeacher().get(0).getTeacherId());
		// System.out.println(section.getSectionId());
		try{
			String query = "insert into teacher(teacher_id,first_name,last_name,user_name, email,pass_word section_id,course_id) values(?,?,?,?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(query);  
			stmt.setString(1, teacher.getTeacherId());
            stmt.setString(2, teacher.getFirstName());
            stmt.setString(3, teacher.getLastName());
			stmt.setString(4, teacher.getFirstName()+teacher.getTeacherId());
			stmt.setString(5, teacher.getEmail());
			stmt.setString(6, teacher.getFirstName()+"aastu");
            stmt.setString(7, teacher.getSectionId());
			stmt.setString(8, teacher.getCourseId());
			row = stmt.executeUpdate();   
			System.out.println(query);
		}catch(Exception er){
			System.out.println(er);
		}
		return row;
	}
	@Override
	public ArrayList<Teacher> getTeacher(String query) {
		try{
			PreparedStatement stmt=con.prepareStatement(query);  
			ResultSet rt = stmt.executeQuery();
			if(teachers.size()>0){
				teachers.clear();
			}
			while(rt.next()){
				String id = rt.getString("teacher_id");
                String fname = rt.getString("first_name");
                String lname = rt.getString("last_name");
				String email = rt.getString("email");
				String courseId = rt.getString("course_id");
				String sectionId = rt.getString("section_id");
				Teacher teach = new Teacher(id, fname, lname,email);
				teach.setCourseId(courseId);
				teach.setSectionId(sectionId);
				teachers.add(teach);
			}
		}catch(Exception er){
			System.out.println(er);
		}
		return teachers;
	}

}

package server.implmentRemoteInterface;

import java.rmi.server.UnicastRemoteObject;
import java.sql.*;

import shared.classes.*;
import shared.remoteInterface.*;
import java.util.*;

import server.database.DbConnection;

public class implementStudent  implements studentInterface {
	Connection con;
	ArrayList<Student>students = new ArrayList<Student>();

	public implementStudent(){
		try {	
	
			UnicastRemoteObject.exportObject(this, 0);
			DbConnection connection = new DbConnection();
            con = connection.getConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public int addStudent(Student student) {
		int row = 0;
		System.out.println(student.getFirstName());
		System.out.println(student.getSectionId());
		System.out.println(student.getLastName());
		System.out.println(student.getStudentId());
		try{
			String query = "insert into student(student_id,first_name,last_name,user_name,pass_word, section_id) values(?,?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(query);  
			stmt.setString(1, student.getStudentId());
            stmt.setString(2, student.getFirstName());
            stmt.setString(3, student.getLastName());
			stmt.setString(4, student.getFirstName()+student.getStudentId());
			stmt.setString(5, student.getFirstName()+"aastu");
            stmt.setString(6, student.getSectionId());
			row = stmt.executeUpdate();   
			System.out.println(query);
		}catch(Exception er){
			System.out.println(er);
		}
		return row;
	}

	@Override
	public ArrayList<Student> getStudent(String query) {
		try{
			PreparedStatement stmt=con.prepareStatement(query);  
			ResultSet rt = stmt.executeQuery();
			if(students.size()>0){
				students.clear();
			}
			while(rt.next()){
				String id = rt.getString("student_id");
                String fname = rt.getString("first_name");
				System.out.println(fname);
                String lname = rt.getString("last_name");
				Student stud = new Student(id, fname, lname);
				students.add(stud);

			}
		}catch(Exception er){
			System.out.println(er);
		}
		return students;
	}
}

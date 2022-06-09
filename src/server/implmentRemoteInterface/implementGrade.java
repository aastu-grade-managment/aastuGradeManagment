package server.implmentRemoteInterface;

import java.rmi.server.UnicastRemoteObject;
import java.sql.*;

import shared.classes.*;
import shared.remoteInterface.*;
import java.util.*;

import server.database.DbConnection;

public class implementGrade  implements gradeInterface {
	Connection con;
	ArrayList<Grade>grades = new ArrayList<Grade>();

	public implementGrade(){
		try {	
	
			UnicastRemoteObject.exportObject(this, 0);
			DbConnection connection = new DbConnection();
            con = connection.getConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public int addGrade(ArrayList<Grade> grades) {
        int row = 0;
		// System.out.println(section.getAllStudent().get(0).getFirstName());
		// System.out.println(section.getAllStudent().get(0).getLastName());
		// System.out.println(section.getAllStudent().get(0).getStudentId());
		// System.out.println(section.getSectionId());
		try{
            String query = "insert into grade(student_id,course_id,value) values(?,?,?)";
            for(Grade grade : grades){
                PreparedStatement stmt=con.prepareStatement(query);
                stmt.setString(1, grade.getStudentId());
                stmt.setString(2, grade.getCourseId());
                stmt.setDouble(3, grade.getValue());
                row = stmt.executeUpdate();   
            }

		}catch(Exception er){
			System.out.println(er);
		}
        return row;
	}
	@Override
	public ArrayList<Grade> getGrade(String query) {
		try{
			PreparedStatement stmt=con.prepareStatement(query);  
			ResultSet rt = stmt.executeQuery();
			if(grades.size()>0){
				grades.clear();
			}
			while(rt.next()){
				String studentId = rt.getString("student_id");
                String teacherId = rt.getString("teacher_id");
                Double value = rt.getDouble("value");
				Grade stud = new Grade(studentId, teacherId, value);
				grades.add(stud);

			}
		}catch(Exception er){
			System.out.println(er);
		}
		return grades;
	}
}

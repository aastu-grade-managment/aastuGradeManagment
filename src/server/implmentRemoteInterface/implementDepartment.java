package server.implmentRemoteInterface;

import java.rmi.server.UnicastRemoteObject;
import java.sql.*;

import shared.classes.*;
import shared.remoteInterface.*;
import java.util.*;

import server.database.DbConnection;

public class implementDepartment  implements departmentInterface {
	Connection con;
	ArrayList<Department>departments = new ArrayList<Department>();

	public implementDepartment(){
		try {	
			UnicastRemoteObject.exportObject(this, 0);
			DbConnection connection = new DbConnection();
            con = connection.getConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public int addDepartment(Department department) {
		int row = 0;
		System.out.println("Oke come");
		System.out.println(department.getDepartmentId());
		System.out.println(department.getDepartmentName());
		// System.out.println(section.getAllStudent().get(0).getStudentId());
		// System.out.println(section.getSectionId());
		try{
			String query = "insert into department(department_id, dep_name) values(?,?)";
			PreparedStatement stmt=con.prepareStatement(query);  
			stmt.setString(1, department.getDepartmentId());
            stmt.setString(2, department.getDepartmentName());
			row = stmt.executeUpdate();   
			System.out.println(query);
		}catch(Exception er){
			System.out.println("Something wrong");
			System.out.println(er);
		}
		return row;
	}

	@Override
	public ArrayList<Department> getDepartment(String query) {
		System.out.println(query);
		try{
			PreparedStatement stmt=con.prepareStatement(query);  
			ResultSet rt = stmt.executeQuery();
			if(departments.size()>0){
				departments.clear();
			}
			while(rt.next()){
				String id = rt.getString("department_id");
                String depName = rt.getString("dep_name");
             
				Department dep = new Department(id, depName);
                
				departments.add(dep);
			}
		}catch(Exception er){
			System.out.println(er);
		}
		return departments;
	}
}

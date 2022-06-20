package server.implmentRemoteInterface;

import java.rmi.server.UnicastRemoteObject;
import java.sql.*;

import shared.classes.*;
import shared.remoteInterface.*;
import java.util.*;

import server.database.DbConnection;

public class implementSection  implements sectionInterface {
	Connection con;
	ArrayList<Section>sections = new ArrayList<Section>();

	public implementSection(){
		try {	
			UnicastRemoteObject.exportObject(this, 0);
			DbConnection connection = new DbConnection();
            con = connection.getConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public int addSection(Section section) {
		int row = 0;
		System.out.println(section.getSectionId());
		System.out.println(section.getSectionName());
		System.out.println(section.getDepartmentId());
		// System.out.println(section.getAllStudent().get(0).getStudentId());
		// System.out.println(section.getSectionId());
		try{
			String query = "insert into section(department_id, section_id,section_name) values(?,?,?)";
			PreparedStatement stmt=con.prepareStatement(query);  
			stmt.setString(1, section.getDepartmentId());
            stmt.setString(2, section.getSectionId());
            stmt.setString(3, section.getSectionName());
			row = stmt.executeUpdate();   
			System.out.println(query);
		}catch(Exception er){
			System.out.println(er);
		}
		return row;
	}

	@Override
	public ArrayList<Section> getSection(String query) {
		try{
			PreparedStatement stmt=con.prepareStatement(query);  
			ResultSet rt = stmt.executeQuery();
			if(sections.size()>0){
				sections.clear();
			}
			while(rt.next()){
				String id = rt.getString("section_id");
                String sectionName = rt.getString("section_name");
                String department = rt.getString("department_id");
				Section sect = new Section(id, sectionName);
                sect.setDepartmentId(department);
				sections.add(sect);
			}
		}catch(Exception er){
			System.out.println(er);
		}
		return sections;
	}
	
}

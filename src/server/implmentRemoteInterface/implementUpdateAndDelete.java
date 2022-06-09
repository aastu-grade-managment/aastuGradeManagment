package server.implmentRemoteInterface;

import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import shared.classes.*;
import shared.remoteInterface.*;
import java.util.*;
import server.database.DbConnection;

public class implementUpdateAndDelete  implements updateDeleteInterface {
	Connection con;
	ArrayList<Teacher>teachers = new ArrayList<Teacher>();

	public implementUpdateAndDelete(){
		try {		
			UnicastRemoteObject.exportObject(this, 0);
			DbConnection connection = new DbConnection();
            con = connection.getConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@Override
	public int updateTable(String query) {
		int row =0;
		try {
			PreparedStatement stmt=con.prepareStatement(query); 
			row = stmt.executeUpdate(query);
		} catch (Exception e) {
	
			return 0;
		}
		return row;
	}
    @Override
	public int deleteTable(String query) {
		int i =0;
		try {
			PreparedStatement stmt=con.prepareStatement(query); 
			i = stmt.executeUpdate(query);
		} catch (Exception e) {
			return 0;
		}
		return i;
	}
}

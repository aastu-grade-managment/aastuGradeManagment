package server.implmentRemoteInterface;

import java.rmi.server.UnicastRemoteObject;
import java.sql.*;

import shared.classes.*;
import shared.remoteInterface.*;
import java.util.*;

import server.database.DbConnection;

public class implementAuthentication  implements authenticationInterface {
	Connection con;
	
	public implementAuthentication(){
		try {	
			UnicastRemoteObject.exportObject(this, 0);
			DbConnection connection = new DbConnection();
            con = connection.getConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public boolean login(String userName, String password, String type) {
		boolean islogged = false;
        String query = "";
        if(type.equals("admin")){
            query = "select * from admin where user_name = ? and pass_word = ? ";
        }
        else if(type.equals("teacher")){
            query = "select * from teacher where user_name = ? and pass_word = ? ";
        }
        else if(type.equals("student")){
            query = "select * from student where user_name = ? and pass_word = ? ";
        }
		try{
			PreparedStatement stmt=con.prepareStatement(query);  
			stmt.setString(1, userName);
            stmt.setString(2, password);
			System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
            islogged = rs.next();
            System.out.println(rs.getString("user_name"));
		}catch(Exception er){
			System.out.println(er);
		}
		return islogged;
	}

}

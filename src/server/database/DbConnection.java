package server.database;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
public class DbConnection implements Remote {
    Connection con;
    public DbConnection(){
        try {	
            UnicastRemoteObject.exportObject(this, 0);    //grade_managment
			Class.forName("com.mysql.cj.jdbc.Driver");  ///javaclass
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grade_managment","root","");
		} catch (Exception e) {
			System.out.println(e);
		}
    }    
    public Connection getConnection() {
        return con;
    }
   
}

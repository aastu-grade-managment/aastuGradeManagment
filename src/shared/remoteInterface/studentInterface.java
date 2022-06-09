package shared.remoteInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import shared.classes.*;

public interface studentInterface extends Remote{
	int addStudent(Student student) throws RemoteException;
	ArrayList<Student> getStudent(String query) throws RemoteException;
	
}

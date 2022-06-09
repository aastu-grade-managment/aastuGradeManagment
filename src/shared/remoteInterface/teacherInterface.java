package shared.remoteInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import shared.classes.*;

public interface teacherInterface extends Remote{
	int addTeacher(Teacher teacher) throws RemoteException;
	ArrayList<Teacher> getTeacher(String query) throws RemoteException;
	
}

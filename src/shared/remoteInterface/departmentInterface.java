package shared.remoteInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import shared.classes.*;

public interface departmentInterface extends Remote{
	int addDepartment(Department department) throws RemoteException;
	ArrayList<Department> getDepartment(String query) throws RemoteException;
}

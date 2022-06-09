package shared.remoteInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import shared.classes.*;

public interface gradeInterface extends Remote{
	int addGrade(ArrayList<Grade> grades) throws RemoteException;
	ArrayList<Grade> getGrade(String query) throws RemoteException;
	
}

package shared.remoteInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import shared.classes.*;

public interface sectionInterface extends Remote{
	int addSection(Section section) throws RemoteException;
	ArrayList<Section> getSection(String query) throws RemoteException;
	
}

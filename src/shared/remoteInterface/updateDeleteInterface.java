package shared.remoteInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface updateDeleteInterface extends Remote{
	int updateTable(String y) throws RemoteException;
	int deleteTable(String x) throws RemoteException;
}

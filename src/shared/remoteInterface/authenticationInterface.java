package shared.remoteInterface;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface authenticationInterface extends Remote{
	boolean login(String userName, String password, String type) throws RemoteException;
}

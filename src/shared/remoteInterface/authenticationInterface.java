package shared.remoteInterface;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import shared.classes.*;

public interface authenticationInterface extends Remote{
	boolean login(String userName, String password, String type) throws RemoteException;
}

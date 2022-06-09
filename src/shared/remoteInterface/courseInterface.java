package shared.remoteInterface;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import shared.classes.*;

public interface courseInterface extends Remote{
	int addCourse(Course course) throws RemoteException;
	ArrayList<Course> getCourse(String query) throws RemoteException;
}

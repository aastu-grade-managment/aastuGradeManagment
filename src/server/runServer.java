package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import server.implmentRemoteInterface.*;

public class runServer {
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		
		implementCourse courseStub = new implementCourse();
		implementSection sectionStub = new implementSection();
		implementDepartment departmentStub = new implementDepartment();
		implementStudent studentStub = new implementStudent();
		implementGrade  gradeStub = new implementGrade();
		implementUpdateAndDelete updateDeleteStub = new implementUpdateAndDelete();
		implementTeacher teacherStub = new implementTeacher();
		implementAuthentication authenticationStub = new implementAuthentication();

		Registry registry = LocateRegistry.createRegistry(2020);
		registry.bind("department", departmentStub);
		registry.bind("section", sectionStub);
		registry.bind("course", courseStub); 
		registry.bind("teacher", teacherStub); 
		registry.bind("student", studentStub); 
		registry.bind("grade", gradeStub); 
		registry.bind("updateDelete", updateDeleteStub); 
		registry.bind("login", authenticationStub); 
		System.out.println("Server Started!");
	}
}

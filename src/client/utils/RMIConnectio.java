package client.utils;
import shared.remoteInterface.*;
import shared.classes.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class RMIConnectio {
    private Registry registry;
    public RMIConnectio(){
        try {
            registry = LocateRegistry.getRegistry("localhost", 2020);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public Registry getRegistry(){
        return this.registry;
    }
}
package lab.mohit.designPattern.proxy.remoteProxy.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    public MyRemoteImpl() throws RemoteException {
    }
    @Override
    public String sayHello() throws RemoteException {
        System.out.println("Executing at server");
        return "Server says, Hi Mohit, how are you doing?";
    }

    public static void main(String[] args) {
        try {
            MyRemote service = new MyRemoteImpl();
//            MessengerService server = new MessengerServiceImpl();
//            MyRemote stub = (MyRemote) UnicastRemoteObject
//                    .exportObject((MyRemote) service, 8890);
            Registry registry = LocateRegistry.createRegistry(8890);
            registry.rebind("RemoteHello", service);
        } catch (Exception ex) {
            System.out.println("Server Failed!");
            ex.printStackTrace();
        }
    }
}

package lab.mohit.designPattern.proxy.remoteProxy.client;

import lab.mohit.designPattern.proxy.remoteProxy.server.MyRemote;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyRemoteClient {
    public static void main(String[] args) {
        new MyRemoteClient().go();
    }

    public void go() {
        try {
            Registry registry = LocateRegistry.getRegistry(8890);
            MyRemote service = (MyRemote) registry.lookup("RemoteHello");
            String s = service.sayHello();
            System.out.println(s);
        } catch (Exception e) {
            System.out.println("Failed!");
            e.printStackTrace();
        }
    }
}

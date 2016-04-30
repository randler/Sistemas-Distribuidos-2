import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Soma extends UnicastRemoteObject {

	protected Soma() throws RemoteException {}
	
	public double somar(double a, double b) {
		return a+b;
	}

}
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Multiplicacao extends UnicastRemoteObject{

	protected Multiplicacao() throws RemoteException {}
	

	public double multiplicar(double a, double b) {
		return a*b;
	}

}

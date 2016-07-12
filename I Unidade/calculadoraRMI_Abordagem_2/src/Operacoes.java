import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class Operacoes extends UnicastRemoteObject implements IOperacoesRemote
{	
	public Operacoes() throws RemoteException{}

	@Override
	public double somar(double a, double b) {
		return a+b;
	}

	@Override
	public double subtrair(double a, double b) {
		return a-b;
	}

	@Override
	public double multiplicar(double a, double b) {
		return a*b;
	}

	@Override
	public double dividir(double a, double b) {
		return a/b;
	}



}




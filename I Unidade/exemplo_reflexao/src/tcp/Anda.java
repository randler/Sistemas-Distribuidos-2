package tcp;


import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class Anda extends UnicastRemoteObject implements Movimentavel {

    static int nPassos = 0;

    public Anda() throws RemoteException { //super() is allways called!
    } // constructor

    public void mova(int n)// move n steps
    {
        System.out.println("Mais movimento (" + n + " passos)!");
        nPassos += n;
        
    } // move()

    public String total()// number of steps walked
    {
        return ("Caminhou " + this.nPassos + " passos!");
    } // total()
} // Walk

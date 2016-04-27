package tcp;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Movimentavel extends Remote
{
    void mova(int n) throws RemoteException;// mova n passos
    String total() throws RemoteException;// numero de passos caminhados
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class ClienteCalc {
	static IOperacoesRemote maq1 = null;
	static IOperacoesRemote maq2 = null;
	static IOperacoesRemote maq3 = null;
	static IOperacoesRemote maq4 = null;
	
	
    public static void main(String[] args) throws IOException {
    	Infix infix = new Infix();
    	String ip0 = "localhost";
    	String ip1 = "localhost";
    	String ip2 = "localhost";
    	String ip3 = "localhost";
        // interface is dealed with like a class!
        if (args.length != 1) {
            System.err.println("\nUsage:\t java ClienteCalc <host_servidor> <objname>\n");
            System.exit(1);
        } // if()
        try {
        	
        	List listServer = new ArrayList<>();
        	while(listServer.size() < 5){
        	Random random = new Random(3);
        	int n = random.nextInt(3);    	
        		if(!listServer.contains("maq"+n)){
        			listServer.add("maq"+n);
        		}
        	}
        	
        	
            String objmaq1 = "//" + ip0 + ":1099/soma";
            System.out.println("Procurando por objeto " + objmaq1);
            maq1 = (IOperacoesRemote) Naming.lookup(objmaq1);// rmiregistry must be running!

            String objmaq2 = "//" + ip1 + ":1099/sub";
            System.out.println("Procurando por objeto " + objmaq2);
            maq2 = (IOperacoesRemote) Naming.lookup(objmaq2);// rmiregistry must be running!

            String objmaq3 = "//" + ip2 + ":1099/mult";
            System.out.println("Procurando por objeto " + objmaq3);
            maq3 = (IOperacoesRemote) Naming.lookup(objmaq3);// rmiregistry must be running!

            String objmaq4 = "//" + ip3 + ":1099/div";
            System.out.println("Procurando por objeto " + objmaq4);
            maq4 = (IOperacoesRemote) Naming.lookup(objmaq4);// rmiregistry must be running!
            
        } // try()
        catch (Exception e)//Seja mais especifico!
        {
            System.err.println("Problemas encontrados! " + e);
            e.printStackTrace();
            System.exit(2);
        } // catch()
        try {
        	BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
            String n;// could use a random number...
            
            System.out.println("digite: ");
            n = in.readLine();
            
            double resp = 0;             
            
            resp = infix.infix(n);
            
            System.out.println("Resposta: " + resp+ "\n");

        } // try()
        catch (RemoteException re) {
            System.err.println("Problemas na chamada remota! " + re);
            re.printStackTrace();
            System.exit(3);
        } // catch()
    } // main() 
    
    
    /*
     * Aqui o cliente vai realizar a chamada pra qual maquina
     * ele deseja enviar de acordo com sorteio ou s� enviar mesmo
     */

    public static IOperacoesRemote aleatorio() {
    	
    	return null;
    }
    
    public static double distribuir(double op1, String operator, double op2) throws RemoteException{
    	double res = 0;
    	/*--------------------------------------- VEI Randomiza aqui
    	
    	*		Esse c�digo ta s� pra um server
    	*		creio que a diferen�a ser� que os servidores(objetos)
    	*		vao ser um array de string
    	*/
    	
    	switch (operator) {
		case "+":
			res = aleatorio().somar(op1, op2);   
			break;
		case "-":
			res = aleatorio().subtrair(op1, op2);
			break;
		case "*":
			res = aleatorio().multiplicar(op1, op2);
			break;
		case "/":
			res = aleatorio().dividir(op1, op2);
			break;

		default:
			break;
		}
    	
		return res;
    	
    }
} // ClientWalk

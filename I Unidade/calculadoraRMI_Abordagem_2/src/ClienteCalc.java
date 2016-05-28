import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class ClienteCalc {
	static IOperacoesRemote opera = null;

	public static void main(String[] args) throws IOException {
		Infix infix = new Infix();
		// interface is dealed with like a class!
		if (args.length != 2) {
			System.err.println("\nUsage:\t java ClienteCalc <host_servidor> <objname>\n");
			System.exit(1);
		} // if()
		try {
			String objname = "//" + args[0] + ":1099/" + args[1];
			System.out.println("Procurando por objeto " + objname);
			opera = (IOperacoesRemote) Naming.lookup(objname);// rmiregistry
																// must be
																// running!
		} // try()
		catch (Exception e)// Seja mais especifico!
		{
			System.err.println("Problemas encontrados! " + e);
			e.printStackTrace();
			System.exit(2);
		} // catch()
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String n;// could use a random number...

			System.out.println("digite: ");
			n = in.readLine();

			double resp = 0;
			long inicio = System.currentTimeMillis();
			resp = infix.infix(n);
			long fim = System.currentTimeMillis();
			System.out.println("Resposta: " + resp + "\n");
			System.out.println("Total: " + (fim - inicio) + "ms");

		} // try()
		catch (RemoteException re) {
			System.err.println("Problemas na chamada remota! " + re);
			re.printStackTrace();
			System.exit(3);
		} // catch()
	} // main()

	/*
	 * Aqui o cliente vai realizar a chamada pra qual maquina ele deseja enviar
	 * de acordo com sorteio ou s� enviar mesmo
	 */
	public static double distribuir(double op1, String operator, double op2) throws RemoteException {
		double res = 0;
		/*--------------------------------------- VEI Randomiza aqui
		
		*		Esse c�digo ta s� pra um server
		*		creio que a diferen�a ser� que os servidores(objetos)
		*		vao ser um array de string
		*/

		switch (operator) {
		case "+":
			res = opera.somar(op1, op2);
			break;
		case "-":
			res = opera.subtrair(op1, op2);
			break;
		case "*":
			res = opera.multiplicar(op1, op2);
			break;
		case "/":
			res = opera.dividir(op1, op2);
			break;

		default:
			break;
		}

		return res;

	}
} // ClientWalk

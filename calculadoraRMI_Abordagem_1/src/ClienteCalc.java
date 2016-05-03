import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClienteCalc {

	public static void main(String[] args) throws IOException {
		Infix infix = new Infix();

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

	} // main()
} // Client

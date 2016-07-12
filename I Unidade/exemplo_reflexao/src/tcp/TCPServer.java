/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tcp;

import java.io.*;
import java.lang.reflect.Method;
import java.net.*;

public class TCPServer {
	public static void main(String[] args) throws Exception {
		String clientSentence;
		String capitalizedSentence;
		ServerSocket welcomeSocket = new ServerSocket(6789);
		while (true) {
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(
					new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(
					connectionSocket.getOutputStream());
			clientSentence = inFromClient.readLine();
			String saidaMetodo[] = clientSentence.split(" ");

			System.out.println("Received: " + clientSentence);
			// capitalizedSentence = clientSentence.toUpperCase() + '\n';
			// String primeiro = saidaMetodo[0] + '\n';
			// outToClient.writeBytes(primeiro);

			String nomeClasse = "tcp.Anda";
			String metodo = "total";
			String move = "mova";

			Class classeGenerica = Class.forName(nomeClasse);
			Object obj = classeGenerica.newInstance();

			Method metodoM, movaM;

			// metodoM = classeGenerica.getMethod(saidaMetodo[0]);
			if (saidaMetodo[0].equals("total")) {
				metodoM = classeGenerica.getMethod(saidaMetodo[0].toString());
				System.out.println(metodoM.invoke(obj).toString());
				outToClient.writeBytes(metodoM.invoke(obj).toString() + '\n');
			} else {
				movaM = classeGenerica.getMethod(saidaMetodo[0].toString(),
						int.class);
				int passos = Integer.parseInt(saidaMetodo[1]);
				movaM.invoke(obj, passos);
				outToClient.write('\n');

			}
		}

	}

}

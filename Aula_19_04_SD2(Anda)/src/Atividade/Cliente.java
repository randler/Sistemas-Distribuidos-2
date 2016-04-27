package Atividade;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream.GetField;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.io.RandomAccessFile;

public class Cliente {

	private static byte[] convertFileToBytes() throws IOException {
		// ------------------------ Converter para array bytes
		// -------------------------
		File file = new File("item.txt");

		byte[] b = new byte[(int) file.length()];
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(b);

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
			e.printStackTrace();
		} catch (IOException e1) {
			System.out.println("Error Reading The File.");
			e1.printStackTrace();
		}
		return b;
	}

	private static byte[] loadBytes(String name) {
		FileInputStream in = null;
		try {
			in = new FileInputStream(name);
			ByteArrayOutputStream byteArrayStream/* buffer */= new ByteArrayOutputStream();
			int bytesread = 0;
			byte[] tbuff = new byte[1024];
			while ((bytesread = in.read(tbuff)) != -1) {
				byteArrayStream.write(tbuff, 0, bytesread);
			}
			return byteArrayStream.toByteArray();
		} catch (IOException e) {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e2) {
				}
			}
			return null;
		}
	}

	public static void main(String[] args) throws UnknownHostException,
			IOException, ClassNotFoundException {
		Socket clientSocket = new Socket("localhost", 6789);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String nome;// could use a random number...
		float custo;
		int unidade;
		String metodo;
		String sentence;
		String modifiedSentence;
		byte[] sendBuf;
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
				System.in));
		DataOutputStream outToServer = new DataOutputStream(
				clientSocket.getOutputStream());

		BufferedReader inFromServer = new BufferedReader(
				new InputStreamReader(clientSocket.getInputStream()));
		while (true) {

			System.out.println("Digite o procedimento: ");
			sentence = inFromUser.readLine();

			switch (sentence) {
			case "adicionar":

				if (clientSocket.isClosed()) {
					clientSocket = new Socket("localhost", 6789);

					outToServer = new DataOutputStream(
							clientSocket.getOutputStream());

					inFromServer = new BufferedReader(
							new InputStreamReader(clientSocket.getInputStream()));
					BufferedReader inAdiciona = new BufferedReader(new InputStreamReader(System.in));

					System.out.println("digite o nome: ");
					nome = inAdiciona.readLine();
					System.out.println("digite o custo: ");
					custo = Float.parseFloat(inAdiciona.readLine());
					System.out.println("digite o unidade: ");
					unidade = inAdiciona.read();

					Produto item = new Produto(nome, unidade, custo);

					try {
						FileOutputStream arq = new FileOutputStream("item.txt");
						ObjectOutputStream objarq = new ObjectOutputStream(arq);
						objarq.writeObject(item);
						objarq.close();

						byte[] t = loadBytes("item.txt");

						outToServer.writeBytes(sentence + " " + t + "\n");

						modifiedSentence = inFromServer.readLine();

						System.out.println("FROM SERVER: " + modifiedSentence);

					} catch (IOException e) {
						System.out.println(e.getMessage());
						e.printStackTrace();

					}
					clientSocket.close();
				}else{

				outToServer = new DataOutputStream(
						clientSocket.getOutputStream());

				inFromServer = new BufferedReader(
						new InputStreamReader(clientSocket.getInputStream()));
				BufferedReader inAdiciona = new BufferedReader(new InputStreamReader(System.in));

				System.out.println("digite o nome: ");
				nome = inAdiciona.readLine();
				System.out.println("digite o custo: ");
				custo = Float.parseFloat(inAdiciona.readLine());
				System.out.println("digite o unidade: ");
				unidade = Integer.parseInt(inAdiciona.readLine());

				Produto item = new Produto(nome, unidade, custo);

				try {
					FileOutputStream arq = new FileOutputStream("item.txt");
					ObjectOutputStream objarq = new ObjectOutputStream(arq);
					objarq.writeObject(item);
					objarq.close();

					byte[] t = loadBytes("item.txt");

					outToServer.writeBytes(sentence + " " + t + "\n");

					modifiedSentence = inFromServer.readLine();

					System.out.println("FROM SERVER: " + modifiedSentence);

				} catch (IOException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();

				}
				clientSocket.close();
				}
				break;
			case "listarTudo":

				if (clientSocket.isClosed()) {
					clientSocket = new Socket("localhost", 6789);

					outToServer = new DataOutputStream(
							clientSocket.getOutputStream());

					inFromServer = new BufferedReader(new InputStreamReader(
							clientSocket.getInputStream()));
					outToServer.writeBytes(sentence + "\n");

					modifiedSentence = inFromServer.readLine();

					System.out.println("FROM SERVER: " + modifiedSentence);
					clientSocket.close();
				}else{

				outToServer = new DataOutputStream(
						clientSocket.getOutputStream());

				inFromServer = new BufferedReader(new InputStreamReader(
						clientSocket.getInputStream()));
				outToServer.writeBytes(sentence + "\n");

				modifiedSentence = inFromServer.readLine();

				System.out.println("FROM SERVER: " + modifiedSentence);
				clientSocket.close();
				}
				break;
			case "alterar":
				if (clientSocket.isClosed()) {
					clientSocket = new Socket("localhost", 6789);

					outToServer = new DataOutputStream(
							clientSocket.getOutputStream());

					inFromServer = new BufferedReader(
							new InputStreamReader(clientSocket.getInputStream()));
					
					System.out.println("Digite o produto que deseja alterar: ");
					String produtoAntigo = inFromUser.readLine();
					
					System.out.println("Inserir novo produto: ");
					String produtoNovo = inFromUser.readLine();
					
					outToServer.writeBytes(sentence+" "+produtoAntigo+" "+produtoNovo+"\n");

					modifiedSentence = inFromServer.readLine();

					System.out.println("FROM SERVER: " + modifiedSentence);
					clientSocket.close();
				}else{
				
				outToServer = new DataOutputStream(
						clientSocket.getOutputStream());

				inFromServer = new BufferedReader(
						new InputStreamReader(clientSocket.getInputStream()));
				
				System.out.println("Digite o produto que deseja alterar: ");
				String produtoAntigo = inFromUser.readLine();
				
				System.out.println("Inserir novo produto: ");
				String produtoNovo = inFromUser.readLine();
				
				outToServer.writeBytes(sentence+" "+produtoAntigo+" "+produtoNovo+"\n");

				modifiedSentence = inFromServer.readLine();

				System.out.println("FROM SERVER: " + modifiedSentence);
				clientSocket.close();
				}
				break;
			case "remover":	
				if (clientSocket.isClosed()) {
					clientSocket = new Socket("localhost", 6789);
					outToServer = new DataOutputStream(
							clientSocket.getOutputStream());

					inFromServer = new BufferedReader(
							new InputStreamReader(clientSocket.getInputStream()));
					
					System.out.println("Digite o produto que deseja remover: ");
					String produtoRemover = inFromUser.readLine();
					
					outToServer.writeBytes(sentence+" "+produtoRemover+"\n");

					modifiedSentence = inFromServer.readLine();

					System.out.println("FROM SERVER: " + modifiedSentence);
					clientSocket.close();
				}else{
				
				outToServer = new DataOutputStream(
						clientSocket.getOutputStream());

				inFromServer = new BufferedReader(
						new InputStreamReader(clientSocket.getInputStream()));
				
				System.out.println("Digite o produto que deseja remover: ");
				String produtoRemover = inFromUser.readLine();
				
				outToServer.writeBytes(sentence+" "+produtoRemover+"\n");

				modifiedSentence = inFromServer.readLine();

				System.out.println("FROM SERVER: " + modifiedSentence);
				clientSocket.close();
				}
				break;
			default:
				break;
			}
			clientSocket.close();
			

		}
	}

	private static byte[] convertFileToBytess() throws IOException {
		// ------------------------ Converter para array bytes
		// -------------------------
		File file = new File("item.txt");

		byte[] b = new byte[(int) file.length()];
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(b);

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
			e.printStackTrace();
		} catch (IOException e1) {
			System.out.println("Error Reading The File.");
			e1.printStackTrace();
		}
		return b;
	}

}

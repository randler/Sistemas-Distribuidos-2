package Atividade;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

import javax.xml.soap.Text;

public class Server {
	
	
	public static void writeBytesToFile(byte[] bytes) throws IOException {
	      BufferedInputStream bos = null;
	      
	    try {
	      FileInputStream fos = new FileInputStream("salva.txt");
	      bos = new BufferedInputStream(fos); 
	      bos.read(bytes);
	    }finally {
	      if(bos != null) {
	        try  {
	          //flush and close the BufferedOutputStream
	          
	          bos.close();
	        } catch(Exception e){}
	      }
	    }
	    }
	
	

	public static Object toObject (byte[] bytes)
	{
	  Object obj = null;
	  try {
	    ByteArrayInputStream bis = new ByteArrayInputStream (bytes);
	    ObjectInputStream ois = new ObjectInputStream (bis);
	     obj = (Produto) ois.readObject();
	  }
	  catch (IOException ex) {
	    //TODO: Handle the exception
	  }
	  catch (ClassNotFoundException ex) {
	    //TODO: Handle the exception
	  }
	  return obj;
	}
	

	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, InterruptedException {
		
		String clientSentence;
        String capitalizedSentence;
        OutputStream out = null;
        
        ServerSocket welcomeSocket = new ServerSocket(6789);
        
        while (true){
        	byte[] b = null;
            Socket conectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(conectionSocket.getInputStream()));
            
            
            /* Saparada ta recebendo e copiado para o arquivo
             * Mas não ta passando do while da linha 95 aqui no Server
             */
            InputStream stream = conectionSocket.getInputStream();
            
            out = new FileOutputStream("itemChegou.txt");
            Thread threadArquivo = new Thread(new SalvarArq(out, stream));
            threadArquivo.start();
            Thread.sleep(2000);
            threadArquivo.interrupt();
            
            
             //---------------------- Fim do que Copia para o arquivo ---------------
			DataOutputStream outToClient = new DataOutputStream(
					conectionSocket.getOutputStream());  
			
            clientSentence = inFromClient.readLine();
            
            
//          FileOutputStream arquivoLeitura = new FileOutputStream("item2.txt");
//
//          arquivoLeitura.write(clientSentence.getBytes());
//          arquivoLeitura.close();
            
            //System.out.println(clientSentence);
            
            //writeBytesToFile(clientSentence.getBytes());
            
            String saidaMetodo [] = clientSentence.split(" ");
            
            String nomeClasse = "Atividade.MercadoDAO";
            String adiciona = "adicionar";
            String alterar = "Alterar";
            String listar = "listarTudo";
            String remover = "Remover";
        	String parametroAlterar1 = " ";
        	String parametroAlterar2 = " ";
        	String parametroRemover = " ";
            
            if(saidaMetodo[0].toString().equals("adicionar")){
                String metodo = saidaMetodo[0];
                String objeto = saidaMetodo[1];
            }else if(saidaMetodo[0].toString().equals("listarTudo")){
            	String metodoListar = saidaMetodo[0];
            }else if(saidaMetodo[0].toString().equals("remover")){
            	String metodoRemover = saidaMetodo[0];
            	parametroRemover = saidaMetodo[1];
            }else if(saidaMetodo[0].toString().equals("alterar")){
            	String metodoAlterar = saidaMetodo[0];
            	parametroAlterar1 = saidaMetodo[1];
            	parametroAlterar2 = saidaMetodo[2];
            }

            
            Class classeGenerica = Class.forName(nomeClasse);
            Object obj = classeGenerica.newInstance();
            
            Method metodoAdicionar, metodoAlterar, metodoListar, metodoRemover;
           
     
    		
    		
    		//System.out.println(item1.toString());
    	   
            System.out.print("Operação: ");
           
        	
        	switch (saidaMetodo[0]) {
			case "adicionar":
				Produto item1 = new Produto();
	    		
	    		try{
	    			FileInputStream arqq = new FileInputStream("item.txt");
	    			ObjectInputStream objectIn = new ObjectInputStream(arqq); //abre
	    			
	    			item1 = (Produto) objectIn.readObject();
	    			arqq.close();
	    			objectIn.close();	
	    			
	    		}catch(IOException e){
	    			System.out.println(e.getMessage());
	    			e.printStackTrace();
	    		}
				metodoAdicionar = classeGenerica.getMethod(saidaMetodo[0].toString(), Produto.class);
				metodoAdicionar.invoke(obj, item1);
            	outToClient.write('\n');
				System.out.println("Chegou adicionar");
				break;
			case "alterar":
				metodoAlterar = classeGenerica.getMethod(saidaMetodo[0], String.class, String.class);
				metodoAlterar.invoke(obj, parametroAlterar1, parametroAlterar2);
				outToClient.write('\n');
				System.out.println("Chegou alterar");
				break;
			case "listarTudo":
				metodoListar = classeGenerica.getMethod(saidaMetodo[0].toString());
				//metodoListar.invoke(obj);
				outToClient.writeBytes(metodoListar.invoke(obj).toString() + '\n');
				System.out.println("Chegou listarTudo");
				break;
			case "remover":
				metodoRemover = classeGenerica.getMethod(saidaMetodo[0], String.class);
				metodoRemover.invoke(obj, parametroRemover);
				outToClient.write('\n');
				System.out.println("Chegou remover");
				break;

				
			default:
				System.out.println("informe uma operação valida");
				break;
			}         
                       
        

	}
        
        

  }
}


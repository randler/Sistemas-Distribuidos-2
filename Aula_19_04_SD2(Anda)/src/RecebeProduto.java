import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class RecebeProduto implements Serializable{
	public static void main(String [] args) throws ClassNotFoundException{
		Produto item1 = new Produto();
	
	try{
		FileInputStream arq = new FileInputStream("item.dat");
		ObjectInputStream objarq = new ObjectInputStream(arq);
		
		item1 = (Produto) objarq.readObject();
		objarq.close();
		
		System.out.println(item1);
	}catch(IOException e){
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	}
	}


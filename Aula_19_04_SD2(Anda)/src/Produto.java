import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Produto implements Serializable{
	private String nome;
	private int unidade;
	private float custo;
	public Produto(){
		this("", 0 , 0.0f);
	}
	public Produto(String nome, int unidade, float custo){
		this.nome = nome;
		this.unidade = unidade;
		this.custo = custo;
	}
	
	@Override
	public String toString(){
		return "nome: "+ nome + "\nunidade: " + unidade + "\nCusto: "+custo;
	}
	public static void main(String [] args) throws ClassNotFoundException{
	Produto item = new Produto("Livro Java", 10, 148.50f);
	
	try{
		FileOutputStream arq = new FileOutputStream("item.dat");
		ObjectOutputStream objarq = new ObjectOutputStream(arq);
		objarq.writeObject(item);
		objarq.close();
	}catch(IOException e){
		System.out.println(e.getMessage());
		e.printStackTrace();
		
	}
	
	
	
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

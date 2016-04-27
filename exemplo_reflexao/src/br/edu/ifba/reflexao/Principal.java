package br.edu.ifba.reflexao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Principal {
	public static void main(String [] args) throws Exception{
		String str = "Anselminho";
		Field atributos[] = null;
		Method metodos[] = null;
		
		Class <Matematica> c = Matematica.class;
		
		atributos = c.getDeclaredFields();
		
		System.out.println("METODOS");
		for (int i = 0; i < atributos.length; i++) {
			System.out.println(atributos[i]);			
		}
		metodos = c.getMethods();
		System.out.println("ATRIBUTOS");
		for (int i = 0; i < metodos.length; i++) {
			System.out.println(metodos[i]);
		}
		
		String stringNomeClass = "br.edu.ifba.reflexao.Matematica";
		String stringNomeMetodoPI = "pi";
		String stringNomeMetodoNome = "nomeClasse";
		String stringNomeSoma = "soma";
		
		Class classeGenerica = Class.forName(stringNomeClass);
		Object obj = classeGenerica.newInstance();
		
		Method metodoPI = classeGenerica.getMethod(stringNomeMetodoPI);
		Method metodoNome = classeGenerica.getMethod(stringNomeMetodoNome);
		Method soma = classeGenerica.getMethod(stringNomeSoma, int.class, int.class);
		
		System.out.println(metodoPI.invoke(obj).toString());
		System.out.println(metodoNome.invoke(stringNomeMetodoNome));
		System.out.println(soma.invoke(obj, 5, 10));
		
	}
}

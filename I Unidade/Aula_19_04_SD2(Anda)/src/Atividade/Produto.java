package Atividade;

import java.io.Serializable;

public class Produto implements Serializable {
	private String nome;
	private int unidade;
	private float custo;
	public Produto(){
		this("", 0, 0.0f);
	}
	public Produto(String nome, int unidade, float custo){
		this.nome = nome;
		this.unidade = unidade;
		this.custo = custo;
	}
	
	@Override
	public String toString(){
		return "nome: "+ nome + " unidade: " + unidade + " Custo: "+custo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getUnidade() {
		return unidade;
	}
	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}
	public float getCusto() {
		return custo;
	}
	public void setCusto(float custo) {
		this.custo = custo;
	}
	 

}

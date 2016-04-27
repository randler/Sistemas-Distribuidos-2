package Atividade;

import java.util.ArrayList;
import java.util.List;

public class MercadoDAO implements Crud{

	
	static List<Produto> cesta = new ArrayList<Produto>();
	
	@Override
	public void adicionar(Produto p1) {
		cesta.add(p1);	
		
	}

	@Override
	public String listarTudo() {
//		for(int i = 0; i < cesta.size(); i++){
//			return cesta.get(i).toString(); 
//		}
//		return "lista";
		return cesta.toString();
	}

	@Override
	public void alterar(String p1, String p2) {

		for (int i = 0; i < cesta.size(); i++) {
			if(p1.equals(cesta.get(i).getNome())){
				cesta.get(i).setNome(p2);
			}
		}
		
	}

	@Override
	public void remover(String p1) {
		for (int i = 0; i < cesta.size(); i++) {
			if(p1.equals(cesta.get(i).getNome())){
				cesta.remove(i);
			}
		}
		
	}

}

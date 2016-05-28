package xmlrpc.cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import xmlrpc.cliente.CalculadoraCliente;

public class RequisicaoCliente {

    /**
     * @param args
     */
    public static void main(String[] args) {
        CalculadoraCliente x = new CalculadoraCliente();
        
       List v = new ArrayList<>();
       List vOrdenada = new ArrayList<>();
        
       Random gerador = new Random();
 
       for (int i = 0; i < 10000; i++) {
            int numero = gerador.nextInt(100) + 0;
            v.add(numero);
       }       
 
       
        vOrdenada.addAll(x.ordena(v.subList(0, 2500)));
        vOrdenada.addAll(x.ordena(v.subList(2500, 5000)));
        vOrdenada.addAll(x.ordena(v.subList(5000, 7500)));
        vOrdenada.addAll(x.ordena(v.subList(7500, 10001)));
           
          vOrdenada = x.ordena(vOrdenada);
        
        
        //System.out.println(x.subtracao(x.soma(14, x.divisao(x.multiplicacao(4, 6), 2)),1));
    }
    
    

}

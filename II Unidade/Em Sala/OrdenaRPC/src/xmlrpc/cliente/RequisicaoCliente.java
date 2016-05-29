package xmlrpc.cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class RequisicaoCliente {

    private static List v = new ArrayList<>();
    private static List vOrdenada = new ArrayList<Integer>();
    private static Random gerador = new Random();
    /**
     * @param args
     */
    public static void main(String[] args) {
       CalculadoraCliente x = new CalculadoraCliente();
      
       gerarAleatorios();
  
       Object[] obj1 =  (Object[]) x.ordena(dividir(0,2500));
       Object[] obj2 = (Object[]) x.ordena(dividir(2500, 5000));
       Object[] obj3 = (Object[]) x.ordena(dividir(5000, 7500));
       Object[] obj4 = (Object[]) x.ordena(dividir(7500, 10000));
       
       merge(obj1,obj2,obj3,obj4);       
       
       Object[] merge =  (Object[]) x.ordena(arrayToVector(vOrdenada));

       for (int i = 0; i < merge.length; i++) {
           System.out.println(merge[i]);
       }
       
       
    }

    private static void gerarAleatorios() {
           for (int i = 0; i < 10000; i++) {
            int numero = gerador.nextInt(2500) + 1;
            v.add(numero);
       } 
    }

    private static Vector dividir(int inicio, int fim) {
        Vector saida = new Vector();
         for (int i = inicio; i < fim; i++) {
            saida.add(Integer.parseInt(v.get(i).toString()));
        }
        return saida;
    }

    private static void merge(Object[] obj1, Object[] obj2, Object[] obj3, Object[] obj4) {
        
        for (int i = 0; i < obj1.length; i++) {
            vOrdenada.add(obj1[i].toString());
        }
        for (int i = 0; i < obj2.length; i++) {
            vOrdenada.add(obj2[i].toString());
        }
        for (int i = 0; i < obj3.length; i++) {
            vOrdenada.add(obj3[i].toString());
        }
        for (int i = 0; i < obj4.length; i++) {
            vOrdenada.add(obj4[i].toString());
        }
    }

    private static Vector arrayToVector(List vOrdenada) {
        Vector saida = new Vector();
        for (int i = 0; i < vOrdenada.size(); i++) {
            saida.add(Integer.parseInt((String) vOrdenada.get(i)));
        }
        return saida;
    }
    
    

}

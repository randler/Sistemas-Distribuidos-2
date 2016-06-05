package xmlrpc.cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class RequisicaoCliente {

    private static CalculadoraCliente maq1 = new CalculadoraCliente();
    private static CalculadoraCliente maq2 = new CalculadoraCliente();
    private static CalculadoraCliente maq3 = new CalculadoraCliente();
    private static CalculadoraCliente maq4 = new CalculadoraCliente();
    private static List v = new ArrayList<>();
    private static List vOrdenada = new ArrayList<Integer>();
    private static Random gerador = new Random();
    private static Object[] obj1, obj2, obj3, obj4, merge;
    private static Thread t1, t2, t3, t4, mergeThread;    
    
    /**
     * @param args
     */
    public Object[] main() throws InterruptedException {
        
       gerarAleatorios();
       rodarThreads();       
       
       while(t1.isAlive() || t2.isAlive() || 
               t3.isAlive() || t4.isAlive()){}
       
       merge(obj1,obj2,obj3,obj4);
       rodarMergeThread();
       
       while(mergeThread.isAlive()){}

       return merge;
       
    }

    private static void gerarAleatorios() {
        if(!v.isEmpty()){
            v = new ArrayList<>();
        }
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
        if(!vOrdenada.isEmpty()){
            vOrdenada = new ArrayList<Integer>();
        }
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

    private static void rodarThreads() {
  
        t1 = new Thread(){
           @Override
           public void run() {
                obj1 =  (Object[]) maq1.ordena(dividir(0,2500));
           }
            
        };
        t1.start();
        
        t2 = new Thread(){
           @Override
           public void run() {
                 obj2 = (Object[]) maq2.ordena(dividir(2500, 5000));
           }
            
        };
        t2.start();
        
        t3 = new Thread(){
           @Override
           public void run() {
                obj3 = (Object[]) maq3.ordena(dividir(5000, 7500));
           }
            
        };
        t3.start();

        t4 = new Thread(){
           @Override
           public void run() {
                obj4 = (Object[]) maq4.ordena(dividir(7500, 10000));
           }
            
        };
        t4.start();        
        
    }

    private static void rodarMergeThread() {
        mergeThread = new Thread(){
           @Override
           public void run() {
                merge =  (Object[]) maq1.ordena(arrayToVector(vOrdenada));

           }
            
        };
        mergeThread.start();
    }
    
    

}

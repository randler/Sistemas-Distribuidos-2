package xmlrpc.servidor;

import java.util.Vector;

public class Calculadora implements ICalculadora{

    @Override
    public Vector ordena(Vector chegou) {
        
        BubbleSort b = new BubbleSort();
        int[] dados = new int[chegou.size()];
        
        for (int i = 0; i < chegou.size(); i++) {
            dados[i] =  (int) chegou.get(i);
        }        
        chegou.removeAllElements();        
        return chegou = b.bubbleSort(dados);
}
}

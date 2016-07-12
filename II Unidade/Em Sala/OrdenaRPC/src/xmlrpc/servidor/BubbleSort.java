package xmlrpc.servidor;

import java.util.Vector;


//Inicio da classe BubbleSort
public class BubbleSort {

    //Método bubbleSort, ele é quem faz a ordenação
    public Vector bubbleSort (int[] dados){
 
        /**
         * Inicia a variável que verifica se houve alguma troca entre os items.
         * Ela é inicializada como true para poder entrar no laço que garantirá que o
         * vetor seja organizado até o final, quantas vezes forem necessárias.
         */
        boolean troca = true;
        
        
        //Laço que garante que o vetor seja verificado quantas vezes forem necessárias
        while (troca) {
            
                /**
                 * Muda o estado da variável troca para que o laço funcione corretamente.
                 * Se ela entrar no for, e seu estado não for mudado para true, significa que não
                 * são mais necessárias verificações no vetor.
                 */
                troca = false;
                
                /**
                 * Este for realiza apenas uma volta no vetor, o que pode não ser suficiente
                 * para a total organização dos itens.
                 */
                for (int posicao = 0; posicao < (dados.length)-1; posicao++){
                    
                        /**
                         * Se o dado da posição atual for maior que o dado da próxima posição, 
                         * é realizado uma troca entre eles.
                         */
                        if (dados[posicao] > dados[posicao+1]){
                            
                                //Copia o valor da próxima posição para uma variável auxiliar
                                int variavelAuxiliar = dados[posicao+1];
                                //Coloca o valor da posição atual na próxima posição
                                dados[posicao+1] = dados[posicao];
                                //A posição atual recebe o valor que foi copiado para a variável auxiliar
                                dados[posicao] = variavelAuxiliar;
                                /**
                                 * Seta true para a troca, indicando que houve troca, evitando assim que 
                                 * o vetor não seja verificado uma próxima vez. 
                                 * Caso o vetor seja percorrido sem trocas, a variável continuará false
                                 * indicando que não há mais necessidade de verificações no vetor.
                                 */
                                troca = true;
                                
                        }
                }
        }     
        
        //Chama uma função para exibir os dados já organizados.
        //imprime(dados);
        Vector saida = new Vector();
        for (int i = 0; i < dados.length; i++) {
            saida.add(dados[i]);
        }
        return saida;
    
    } //Fim do bubbleSort
}
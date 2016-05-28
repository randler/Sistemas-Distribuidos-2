package xmlrpc.cliente;

import xmlrpc.cliente.CalculadoraCliente;

public class RequisicaoCliente {

    /**
     * @param args
     */
    public static void main(String[] args) {
        CalculadoraCliente x = new CalculadoraCliente();
        System.out.println(x.subtracao(x.soma(14, x.divisao(x.multiplicacao(4, 6), 2)),1));
    }

}

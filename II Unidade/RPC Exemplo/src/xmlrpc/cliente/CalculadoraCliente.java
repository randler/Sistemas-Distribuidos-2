package xmlrpc.cliente;

public class CalculadoraCliente {

    private ClienteXmlRpc cliente;

    public CalculadoraCliente() {
        cliente = new ClienteXmlRpc();
    }

    public int soma(int x, int y) {
        Object[] parametros = new Object[]{new Integer(x), new Integer(y)};
        Integer resultado = (Integer) cliente.executar("Calc.soma", parametros);
        return resultado;
    }

    public int subtracao(int x, int y) {
        Object[] parametros = new Object[]{new Integer(x), new Integer(y)};
        Integer resultado = (Integer) cliente.executar("Calc.subtracao", parametros);
        return resultado;
    }
    
    public int multiplicacao(int x, int y) {
        Object[] parametros = new Object[]{new Integer(x), new Integer(y)};
        Integer resultado = (Integer) cliente.executar("Calc.multiplicacao", parametros);
        return resultado;
    }
    
    public int divisao(int x, int y) {
        Object[] parametros = new Object[]{new Integer(x), new Integer(y)};
        Integer resultado = (Integer) cliente.executar("Calc.divisao", parametros);
        return resultado;
    }
    
}

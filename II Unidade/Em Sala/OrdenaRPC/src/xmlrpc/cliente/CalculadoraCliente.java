package xmlrpc.cliente;

import java.util.List;
import java.util.Vector;

public class CalculadoraCliente {

    private ClienteXmlRpc cliente;

    public CalculadoraCliente() {
        cliente = new ClienteXmlRpc();
    }

    public List ordena(List vetor) {
        Object[] parametros = new Object[]{vetor};
        Vector resultado =  (Vector) cliente.executar("Calc.ordena", parametros);
        return resultado;
    }
    
}

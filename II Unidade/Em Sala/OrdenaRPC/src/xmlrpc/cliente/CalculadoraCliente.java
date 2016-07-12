package xmlrpc.cliente;

import java.util.ArrayList;
import java.util.Vector;

public class CalculadoraCliente {

    private ClienteXmlRpc cliente;

    public CalculadoraCliente() {
        cliente = new ClienteXmlRpc();
    }


    public Object ordena(Vector vetor) {
        Object[] parametros = new Object[]{vetor};
        Object resultado = cliente.executar("Calc.ordena", parametros);
        
        return resultado;
    }
    
}

package xmlrpc.cliente;

import java.net.URL;
import org.apache.xmlrpc.*;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class ClienteXmlRpc {

    private static final String urlServidor = "http://localhost:8185"; //DEFINE A URL DO SERVIDOR
    private XmlRpcClient xmlrpc;

    public ClienteXmlRpc() {
        try {
            XmlRpcClientConfigImpl configuracaoCliente = new XmlRpcClientConfigImpl();
            configuracaoCliente.setServerURL(new URL(urlServidor));

            xmlrpc = new XmlRpcClient();
            xmlrpc.setConfig(configuracaoCliente);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public Object executar(String comando, Object[] parametros) {
        try {
            Object resposta = xmlrpc.execute(comando, parametros);
            return resposta;
        } catch (XmlRpcException e) {
            e.printStackTrace();
            return null;
        }
    }

}

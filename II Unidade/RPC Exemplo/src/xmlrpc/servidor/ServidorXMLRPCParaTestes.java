package xmlrpc.servidor;
//https://archive.apache.org/dist/ws/xmlrpc/apache-xmlrpc-current-bin.zip
import xmlrpc.servidor.Calculadora;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.webserver.WebServer;

public class ServidorXMLRPCParaTestes {

    private static ServidorXMLRPCParaTestes euMesmo = null;

    private ServidorXMLRPCParaTestes() {
        try {
            WebServer server = new WebServer(8185); // Cria um servidor na porta 8185
            XmlRpcServer servidor = server.getXmlRpcServer(); // Pega o servidor XmlRpc
            PropertyHandlerMapping phm = new PropertyHandlerMapping();
            phm.addHandler("Calc", Calculadora.class); // Adiciona um novo "handler" ao PHM
            servidor.setHandlerMapping(phm); // Define o handler no servidor
            server.start(); // inicia o servidor.
        } catch (Exception exception) {
            System.err.println("JavaServer: " + exception);
        }
    }

    public static ServidorXMLRPCParaTestes obterInstancia() {
        if (euMesmo == null) {
            euMesmo = new ServidorXMLRPCParaTestes();
        }
        return euMesmo;
    }
}

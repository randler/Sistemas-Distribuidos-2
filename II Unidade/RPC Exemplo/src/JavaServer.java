
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.webserver.*;

public class JavaServer {

    public JavaServer() {
    }

    public Integer sum(int x, int y) {
        return new Integer(x + y);
    }

    public Integer sub(int x, int y) {
        return new Integer(x - y);
    }
    public Integer mul(int x, int y) {
        return new Integer(x * y);
    }
    public Integer div(int x, int y) {
        return new Integer(x / y);
    }
    public static void main(String[] args) {

        try {

            System.out.println("Tentando iniciar o Servidor XML-RPC...");

            WebServer server = new WebServer(9000);
            XmlRpcServer servidor = server.getXmlRpcServer(); // Pega o servidor XmlRpc
            
            PropertyHandlerMapping phm = new PropertyHandlerMapping();           
            phm.addHandler("sample", JavaServer.class); // Adiciona um novo "handler" ao PHM
            servidor.setHandlerMapping(phm); // Define o handler no servidor
            
            server.start(); // inicia o servidor.

            System.out.println("Iniciado com Sucesso.");
            System.out.println("Aceitando requisições. (Finalize o programa para parar.)");

        } catch (Exception exception) {
            System.err.println("JavaServer: " + exception);
        }
    }
}

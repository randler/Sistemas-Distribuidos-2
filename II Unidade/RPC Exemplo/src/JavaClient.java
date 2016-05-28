
import java.net.URL;
import java.util.*;
import org.apache.xmlrpc.client.*;

public class JavaClient {

    public static void main(String[] args) {

        try {

            XmlRpcClient server = new XmlRpcClient();
            XmlRpcClientConfigImpl configuracaoCliente = new XmlRpcClientConfigImpl();
            configuracaoCliente.setServerURL(new URL("http://localhost:9000"));
            server.setConfig(configuracaoCliente);

            Vector params = new Vector();
                 

            params.addElement(new Integer(6));
            params.addElement(new Integer(4));

            Object result = server.execute("sample.mul", params);

            params.removeAllElements();
            params.addElement(new Integer((int) result));
            params.addElement(new Integer(2));
            
            result = server.execute("sample.div", params);

            params.removeAllElements();
            params.addElement(new Integer((int) result));
            params.addElement(new Integer(14));

            result = server.execute("sample.sum", params);
            
            params.removeAllElements();
            params.addElement(new Integer((int) result));
            params.addElement(new Integer(1));

            result = server.execute("sample.sub", params);
            
            int sum = (Integer) result;
            System.out.println("The sum is: " + sum);

        } catch (Exception exception) {
            System.err.println("JavaClient: " + exception);
        }
    }
}

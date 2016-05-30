/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlrpc.Executor;

import xmlrpc.frame.ClienteFrame;
import xmlrpc.frame.ServidorFrame;

/**
 *
 * @author randler
 */
public class ClientMain {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException {
         /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteFrame().setVisible(true);
            }
        });
    


    }
    
}

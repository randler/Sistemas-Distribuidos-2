/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlrpc.servidor;

/**
 *
 * @author randler
 */
public interface ICalculadora {
    
    public int soma(int x, int y);
    public int subtracao(int x, int y);
    public int multiplicacao(int x, int y);
    public int divisao(int x, int y);
    
    
    
}

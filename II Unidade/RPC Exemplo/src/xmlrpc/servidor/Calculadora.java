package xmlrpc.servidor;

public class Calculadora implements ICalculadora{

    @Override
    public int soma(int x, int y) {
        return x + y;
    }

    @Override
    public int subtracao(int x, int y) {
        return x - y;
    }

    @Override
    public int multiplicacao(int x, int y) {
        return x * y;
    }

    @Override
    public int divisao(int x, int y) {
        return x / y;
    }

}

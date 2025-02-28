package banco;

public class ContaEspecial extends Conta{
    private double limite;
    public ContaEspecial(int n, double s, double lim){
        super(n,s); limite = lim;
    }
    @Override
    public void depositar(double valor){
        saldo = saldo + valor * 1.1;
    }
    @Override
    public boolean sacar(double valor){
        if (valor <= saldo+limite){
            saldo -= valor;
            return true;
        }
        return false;
    }
    public void aumentar(double valor){
        limite += valor;
    }
}
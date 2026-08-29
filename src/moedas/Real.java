package moedas;


public class Real extends Moeda
{	
	public Real(double valor)
	{
		super("Real", valor);
	}
	
	@Override
	public double info()
	{
		return super.valor;
	}
	
	@Override
	public double converter(double taxaConversao)
	{
		return super.valor;
	}
}

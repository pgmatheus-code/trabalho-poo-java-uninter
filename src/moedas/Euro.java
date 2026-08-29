package moedas;


public class Euro extends Moeda
{	
	public Euro(double valor)
	{
		super("Euro", valor);
	}
	
	@Override
	public double info()
	{
		return super.valor;
	}
	
	@Override
	public double converter(double taxaConversao)
	{
		return super.valor * taxaConversao;
	}
}
